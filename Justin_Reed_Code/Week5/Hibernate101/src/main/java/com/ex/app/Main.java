package com.ex.app;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;

public class Main {
	
	public static void main(String[] args) {
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurcolor("White");
		b.setHeight(102.8);
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}

}
