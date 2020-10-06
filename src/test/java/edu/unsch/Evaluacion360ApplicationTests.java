package edu.unsch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import edu.unsch.controllers.LoginController;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class Evaluacion360ApplicationTests {

	@Autowired
	private LoginController loginController;

	@Test
	void contextLoads() {

		assertThat(loginController).isNotNull();
	}

}