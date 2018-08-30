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
		r.setAmount(523.21);
		r.setAuthor(4);
		r.setDescription("aewhwh");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDate now = LocalDate.now();
		//r.setResolver(2);
		r.setStatusId(1);
		r.setSubmitted(LocalDate.now());
		r.setTypeId(1);
		re.save(r);

		
	}
	

}
