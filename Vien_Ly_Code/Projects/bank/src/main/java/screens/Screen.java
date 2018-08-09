package screens;

public interface Screen {
	Screen display();
	// for polymorphic purpose, we're instantiating most screens as Screen rather than their specific types
	// as such, each screen needs to guarantee a getScreenName method;
	String getScreenName();
	void setPreviousScreen(Screen previous);
}
