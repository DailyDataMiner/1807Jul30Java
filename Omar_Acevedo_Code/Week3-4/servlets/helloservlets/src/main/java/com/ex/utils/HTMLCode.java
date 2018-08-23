package com.ex.utils;

import com.ex.pojos.User;

public class HTMLCode {
	public static String htmlcode(User u) {
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"	<meta charset=\"UTF-8\">\n" + 
				"	<title>Insert title here</title>\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" + 
				"\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	\n" + 
				"	<div class=\"jumbotron\">\n" + 
				"		\n" + 
				"		<h1><i>Welcome, " + u.getUsername() + "</i></h1>\n" + 
				"		\n" + 
				"	</div>\n" + 
				"	\n" + 
				"    <!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\" crossorigin=\"anonymous\"></script>\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>        \n" + 
				"	 -->\n" + 
				"</body>\n" + 
				"</html>";
	}
}
