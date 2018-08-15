package Application;

import java.sql.Connection;

import Util.JDBCConnection;
import service.UserService;

public class main {
	public static void main(String[] args) {
		
		System.out.println(UserService.getUserService().returnBankUser(1));
	}
}
