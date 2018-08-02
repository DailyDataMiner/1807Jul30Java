package com.revature.microrealm_v2;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Simulator extends Avatar {
	
	public static void main(String[] args) {
		Map<Avatar, String> preAvatarList = initAvatars(); // or prepare Avatars?
//		Map<HumanBluePrint, String> preAvatarList = initAvatars(); // or prepare Avatars?
		runSimulation(preAvatarList);
	}
	
	private static void runSimulation(Map<Avatar, String> p_preAvatarList) {
		
		print("\n------------------------------------------------------------");
		
		//	Format of avatar list value -> < Avatar Object {name, gender}, Role >
		for (Map.Entry<Avatar, String> avatar : p_preAvatarList.entrySet()) {
			
			print("Info about Avatar #" + avatar.hashCode());
			print("\tName: " + avatar.getKey().getName());
			print("\tGiven Role: " + avatar.getValue());
//			print("\t" + Simulator.class.getName());
			print("\tHuman Actions it can do:");
			avatar.getKey().talks();
			avatar.getKey().walk();
			avatar.getKey().run();
			avatar.getKey().sneeze();
			avatar.getKey().salute();
			avatar.getKey().sleep();
			avatar.getKey().wakeUp();
			
			print("\n------------------------------------------------------------");
			
		}

////	Avatar avatar1 = new Avatar("Omar");
////	avatar1.talks();
////	Scanner t = new Scanner(null);
		
	}
		
	private static Map initAvatars() {
		
//		String[] avatarNameList = {"Omar", "Laura", "Billy", "Joel", "Camille", "Salam", "Mee", "Taco", "Tuesday", "Becky", "Baker"};
//		String[][] avatarNameList = {"Omar", "Laura", "Billy", "Joel", "Camille", "Salam", "Mee", "Taco", "Tuesday", "Becky", "Baker"};
		String[][] avatarNameList = new String[5][2];
		
		avatarNameList[0][0] = "Omar";
		avatarNameList[0][1] = "male";
		
		avatarNameList[1][0] = "Laura";
		avatarNameList[1][1] = "female";
		
		avatarNameList[2][0] = "Billy";
		avatarNameList[2][1] = "male";
		
		avatarNameList[3][0] = "Joel";
		avatarNameList[3][1] = "male";

		avatarNameList[3][0] = "Camille";
		avatarNameList[3][1] = "female";

		avatarNameList[4][0] = "Becky";
		avatarNameList[4][1] = "female";

//		Avatar avatar;
		HumanBluePrint avatar;
		
//		Map<Avatar, String> avatarList = new HashMap<>();
		Map<HumanBluePrint, String> avatarList = new HashMap<>();

		String name;
		String gender;
		String role;
		
		Random rand = new Random();
		String[] roleList = {"Warrior", "Hunter", "Mage", "Healer"};
		
		for ( int i = 0; i < avatarNameList.length; i++ ) {
			
			name = avatarNameList[i][0];
			gender = avatarNameList[i][1];
			role = roleList[rand.nextInt(roleList.length)];
			
			avatar = new Avatar(name, gender);
//			avatar.setRole(role);
		
			avatarList.put(avatar, role);
			
		}
		
		return avatarList;
		
	}
	
}
