package com.revature.pojos;

public class UserAccounts {

		private int Userid;
		private int Accountid;
		
		public void UserAccount() {};
		
		public UserAccounts(int Userid, int Accountid) {
			super();
			this.Userid = Userid;
			this.Accountid = Accountid;
		}
	
		public int getUser_id() {
			return Userid;
		}
	
		public void setUser_id(int User_id) {
			this.Userid = User_id;
		}
	
		public int getAccount_id() {
			return Accountid;
		}
	
		public void setAccount_id(int Account_id) {
			this.Accountid = Account_id;
		}
		
		@Override
		public String toString() {
			return "User_Account [user Id=" + Userid + ", Account Id=" + Accountid + "]";
		}
		
	}
