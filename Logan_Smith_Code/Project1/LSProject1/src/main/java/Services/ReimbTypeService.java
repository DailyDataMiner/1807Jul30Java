package Services;

import java.util.List;

import DAOs.ReimbTypeDAO;
import POJOs.ReimbType;

public class ReimbTypeService {
	static ReimbTypeDAO rtDao = new ReimbTypeDAO();

	public static List<ReimbType> getAll() {
		return rtDao.findAll();
	}

	public static ReimbType getOne(int input) {
		return rtDao.findOne(input);
	}
	public static ReimbType getByTypeName(String input) {
		return rtDao.findByTypeName(input);
	}

	public static ReimbType saveReimbType(ReimbType a) {
		return rtDao.save(a);
	}
}
