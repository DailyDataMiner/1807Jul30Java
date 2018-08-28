package Services;

import java.util.List;

import DAOs.ReimbTypeDAO;
import POJOs.ReimbType;

public class ReimbTypeService {
	static ReimbTypeDAO rtDao = new ReimbTypeDAO();

	public List<ReimbType> getAll() {
		return rtDao.findAll();
	}

	public ReimbType getOne(int input) {
		return rtDao.findOne(input);
	}

	public ReimbType saveReimbType(ReimbType a) {
		return rtDao.save(a);
	}
}
