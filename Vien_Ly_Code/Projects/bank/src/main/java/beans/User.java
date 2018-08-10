package beans;

import java.util.List;

/*
 * singleton class User, 
 */
public final class User {
	private boolean isLoggedIn = false;
	private List<Account> accounts;
	
    private static class FooLoader {
        private static final User INSTANCE = new User();
    }
    private User() {
        if (FooLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }
    public static User getInstance() {
        return FooLoader.INSTANCE;
    }
    
    public void logIn() {
    	
    }
}
