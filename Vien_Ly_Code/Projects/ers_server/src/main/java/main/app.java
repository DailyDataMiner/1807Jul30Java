package main;

import java.sql.Timestamp;

import DAO.UserDAO;
import beans.Reimbursement;
import beans.ReimbursementStatus;
import beans.ReimbursementType;
import beans.User;
import beans.UserRole;
import exceptions.InvalidCredentialsException;
import exceptions.NoPermissionException;
import exceptions.NoSuchUserException;
import exceptions.UsernameTakenException;
import services.ReimbursementService;
import services.UserService;

public class app {

	public static void main(String[] args)
			throws NoPermissionException, UsernameTakenException, NoSuchUserException, InvalidCredentialsException {
//		UserDAO uDAO = new UserDAO();
//		UserService uService = new UserService();
//		User admin = uDAO.findByUsername("admin");
//		User user = new User("isa", "password", "isa", "svg", "isa@3.com", UserRole.EMPLOYEE);	
//		uService.createUser(user);

//		Reimbursement ri = new Reimbursement(700.00, new Timestamp(System.currentTimeMillis()), "one night in vegas", 46, ReimbursementStatus.PENDING, ReimbursementType.LODGING);
		ReimbursementService riService = new ReimbursementService();
//		System.out.println(riService.createReimbursement(ri));
		for (Reimbursement ri : riService.findByType(ReimbursementType.LODGING)) {
			System.out.println(ri);
		}
		
//		Reimbursement ri = riService.findOne(7);
//		
//		riService.resolve(ri, admin, true);
	}
}
