import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

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
	}
	

}
