import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.servlets.LoadViewServlet;

public class maintest {
	private static Logger log = Logger.getLogger(maintest.class);
	public static void main(String[] args) {
		ReimbursementService re = new ReimbursementService();

		Reimbursement r = new Reimbursement();
		r.setAmount(120);
		r.setAuthor(42);
		r.setDescription("Look at my name. What do you think i need the money for?");
		LocalDate inputDate = LocalDate.of(2005,7,25);
		//r.setResolver(2);
		r.setStatusId(1);
		r.setSubmitted(inputDate);
		r.setTypeId(3);
		re.addReimbursement(r);

		
	}
	

}
