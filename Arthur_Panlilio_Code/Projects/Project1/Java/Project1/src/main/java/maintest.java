import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.UserService;

public class maintest {

	public static void main(String[] args) {
		ReimbursementDAO re = new ReimbursementDAO();

		Reimbursement r = new Reimbursement();
		r.setAmount(50.12);
		r.setAuthor(3);
		r.setDescription("Bought a cow to impress client");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDate now = LocalDate.now();
		r.setResolved(LocalDate.now());
		r.setResolver(2);
		r.setStatusId(1);
		r.setSubmitted(LocalDate.now());
		r.setTypeId(1);
		re.save(r);
		System.out.println(re.findAll());
		UserService uService = new UserService();
		System.out.println(uService.getAll());
		User u = new User("fafaga", "abvs", "Brob", "Brobber", "Br@B.com", 1);
		uService.addUser(u);
		User a = new User("faea", "abvs", "Brob", "Brobber", "Br@B.com", 1);
		uService.addUser(a);
		
	}
	

}
