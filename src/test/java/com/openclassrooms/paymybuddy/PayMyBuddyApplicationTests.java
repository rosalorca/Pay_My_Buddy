package com.openclassrooms.paymybuddy;

import com.openclassrooms.controllers.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PayMyBuddyApplicationTests {
	@Autowired
	private LoginController controller;

	@Test
	void contextLoads() {


	}

}
