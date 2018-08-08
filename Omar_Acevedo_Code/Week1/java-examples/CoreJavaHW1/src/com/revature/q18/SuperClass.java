package com.revature.q18;
import java.util.HashMap;

import com.revature.helpers.HelperFunctions;

public abstract class SuperClass extends HelperFunctions {
	
	abstract HashMap<String, Boolean> checkForUppercase(String p_str);
	
	abstract String lowerToUpper(String strToConvert);
	
	abstract void convertAndShow(String strToConvert);

}
