package com.iantimothyjohnson.assignments.project1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.iantimothyjohnson.assignments.project1.dao.MockReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.dao.MockUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.ReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementStatus;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementType;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

class ReimbursementServiceTest {
    static final String TEST_MANAGER_USERNAME = "testmanager";
    static final char[] TEST_MANAGER_PASSWORD = "password".toCharArray();
    static final String TEST_EMPLOYEE_USERNAME = "testemployee";
    static final char[] TEST_EMPLOYEE_PASSWORD = "password123".toCharArray();

    UserDAO userDao;
    ReimbursementDAO reimbursementDao;
    User testManager;
    User testEmployee;
    List<Reimbursement> employeeReimbursements;

    @BeforeEach
    void setUp() throws Exception {
        userDao = new MockUserDAO();
        reimbursementDao = new MockReimbursementDAO();

        // Insert a couple of users to test with.
        testManager = new User();
        testManager.setRole(UserRole.MANAGER);
        testManager.setUsername(TEST_MANAGER_USERNAME);
        testManager.setFirstName("Test");
        testManager.setLastName("Manager");
        testManager.setEmail("email@official.com");
        testManager.setPasswordSalt(Passwords.generateSalt());
        testManager.setPasswordHash(Passwords.hashPassword(
            TEST_MANAGER_PASSWORD, testManager.getPasswordSalt()));

        testEmployee = new User();
        testEmployee.setRole(UserRole.EMPLOYEE);
        testEmployee.setUsername(TEST_EMPLOYEE_USERNAME);
        testEmployee.setFirstName("Test");
        testEmployee.setLastName("Employee");
        testEmployee.setEmail("email@email.com");
        testEmployee.setPasswordSalt(Passwords.generateSalt());
        testEmployee.setPasswordHash(Passwords.hashPassword(
            TEST_EMPLOYEE_PASSWORD, testEmployee.getPasswordSalt()));

        userDao.insert(testManager);
        userDao.insert(testEmployee);

        // Give the employee a couple reimbursements.
        employeeReimbursements = new ArrayList<>();

        Reimbursement r1 = new Reimbursement();
        r1.setStatus(ReimbursementStatus.PENDING);
        r1.setType(ReimbursementType.FOOD);
        r1.setAmount(new BigDecimal("15.00"));
        r1.setAuthorId(testEmployee.getId());
        r1.setSubmitted(OffsetDateTime.now().minusDays(14));

        employeeReimbursements.add(r1);
        reimbursementDao.insert(r1);

        Reimbursement r2 = new Reimbursement();
        r2.setStatus(ReimbursementStatus.APPROVED);
        r2.setType(ReimbursementType.LODGING);
        r2.setAmount(new BigDecimal("149.99"));
        r2.setAuthorId(testEmployee.getId());
        r2.setSubmitted(OffsetDateTime.now().minusDays(7));
        r2.setResolved(OffsetDateTime.now().minusMinutes(10));

        employeeReimbursements.add(r2);
        reimbursementDao.insert(r2);
    }

    @AfterEach
    void tearDown() throws Exception {
        userDao = null;
        reimbursementDao = null;
        testEmployee = null;
        testManager = null;
        employeeReimbursements = null;
    }

    @Nested
    @DisplayName("with actions performed as a manager")
    class AsManager {
        ReimbursementService reimbursementService;

        @BeforeEach
        void setUp() {
            reimbursementService = new ReimbursementService(testManager,
                reimbursementDao);
        }

        @AfterEach
        void tearDown() {
            reimbursementService = null;
        }

        @Test
        @DisplayName("can get an employee's reimbursements")
        void testGetEmployeeReimbursements() throws Exception {
            assertEquals(employeeReimbursements,
                reimbursementService.getAllForUser(testEmployee),
                "Employee's reimbursements do not match what was inserted into the database.");
        }
    }

    @Nested
    @DisplayName("with actions performed as an ordinary employee")
    class AsEmployee {
        ReimbursementService reimbursementService;

        @BeforeEach
        void setUp() {
            reimbursementService = new ReimbursementService(testEmployee,
                reimbursementDao);
        }

        @AfterEach
        void tearDown() {
            reimbursementService = null;
        }

        @Test
        @DisplayName("cannot get another employee's reimbursements")
        void testGetOtherReimbursementsPermissionDenied() throws Exception {
            assertThrows(PermissionDeniedException.class,
                () -> reimbursementService.getAllForUser(testManager),
                "Successfully got another user's reimbursements.");
        }

        @Test
        @DisplayName("can get own reimbursements")
        void testGetOwnReimbursements() throws Exception {
            assertEquals(employeeReimbursements,
                reimbursementService.getAllForUser(testEmployee),
                "Employee's reimbursements do not match what was inserted into the database.");
        }
    }
}
