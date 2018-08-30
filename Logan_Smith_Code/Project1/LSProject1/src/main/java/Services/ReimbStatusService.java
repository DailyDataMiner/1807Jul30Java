package Services;

import java.util.List;

import DAOs.ReimbStatusDAO;
import POJOs.ReimbStatus;
import POJOs.ReimbType;

public class ReimbStatusService {
	static ReimbStatusDAO rsDao = new ReimbStatusDAO();

	public static List<ReimbStatus> getAll() {
		return rsDao.findAll();
	}

	public static ReimbStatus getOne(int input) {
		return rsDao.findOne(input);
	}
	
	public static ReimbStatus getByStatusName(String input) {
		return rsDao.findByStatusName(input);
	}

	public static ReimbStatus saveReimbStatus(ReimbStatus a) {
		return rsDao.save(a);
	}

}
