package DAOs;

import POJOs.User;
import POJOs.UserInformation;

public interface UserDAO {

	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	User getUser(String input);
	
}
