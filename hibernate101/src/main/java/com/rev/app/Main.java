package com.rev.app;

import com.rev.dao.BearDao;
import com.rev.pojos.Bear;

public class Main {

	public Main() {

		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("Brown");
		b.setHeight(90.13);

	}

	BearDao bd = new BearDao();
	bd.addBear(b);
	
}
