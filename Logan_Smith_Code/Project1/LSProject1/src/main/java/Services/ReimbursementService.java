package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAOs.ReimbStatusDAO;
import DAOs.ReimbursementDAO;
import Models.ReimbModel;
import POJOs.Reimbursement;
import POJOs.User;

public class ReimbursementService {
	static ReimbursementDAO rDao = new ReimbursementDAO();
	static ReimbStatusDAO rsDao = new ReimbStatusDAO();

	static public List<Reimbursement> getAll() {
		return rDao.findAll();
	}
	
	static public List<Reimbursement> getAllByStatus(int statusID) {
		return rDao.findAllByStatus(statusID);
	}
	
	static public List<Reimbursement> getAllByType(int typeID) {
		return rDao.findAllByType(typeID);
	}
	
	static public List<Reimbursement> getAllByAuthor(int authorID) {
		return rDao.findAllByAuthor(authorID);
	}
	
	static public List<Reimbursement> getAllByResolver(int resolverID) {
		return rDao.findAllByResolver(resolverID);
	}

	static public Reimbursement getOne(int input) {
		return rDao.findOne(input);
	}

	static public Reimbursement saveReimbursement(Reimbursement a) {
		return rDao.save(a);
	}

	static public void deleteReimbursement(Reimbursement a) {
		rDao.delete(a);
	}

	static public Reimbursement updateReimbursement(Reimbursement a, User iresolver, int iresolvedid) {
		a.setReimbResolver(iresolver);
		a.setReimbStatus(rsDao.findOne(iresolvedid));
		return rDao.updateReimbursementResolved(a);
	}
	static public Reimbursement createUserReimb(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("reached here 5");
		ReimbModel rm = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			rm = mapper.readValue(req.getReader(), ReimbModel.class);
			System.out.println(rm);
			}
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		Reimbursement r = new Reimbursement(rm.getReimbAmount(), UserService.getOne(rm.getReimbAuthor()), rm.getReimbDesc(),
				ReimbTypeService.getByTypeName(rm.getReimbType()), new Timestamp(System.currentTimeMillis()), ReimbStatusService.getOne(1));
		return saveReimbursement(r);
	}
	public static Reimbursement approveReimb(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("reached here 5");
		ReimbModel rm = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			rm = mapper.readValue(req.getReader(), ReimbModel.class);
			System.out.println(rm);
			}
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		Reimbursement r = getOne(rm.getReimbID());
		r.setReimbResolved(new Timestamp(System.currentTimeMillis()));
		r.setReimbStatus(ReimbStatusService.getByStatusName(rm.getReimbStatus()));
		r.setReimbResolver(UserService.getOne(rm.getReimbResolver()));
		System.out.println();
		return rDao.updateReimbursementResolved(r);
	}
	static public List<Reimbursement> servletGetAllByAuthor(HttpServletRequest req, HttpServletResponse resp) {
		String input = "";
		try (BufferedReader bf = req.getReader()) {
		input = bf.readLine();
		System.out.println("Input: " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllByAuthor(Integer.parseInt(input));
	}
}
