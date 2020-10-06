package edu.unsch.testdao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import edu.unsch.dao.ModuloDao;
import edu.unsch.entities.Modulo;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ModuloDaoTest {
	@Autowired
	private ModuloDao moduloDao;

	@Test
	void createModuleValidaPersistent() {
		Modulo modulo = new Modulo();
		modulo.setIdmodulo(1);
		modulo.setNombre("Admin 1");
		modulo.setIcono("dsad");
		
		assertThat(moduloDao.save(modulo)).isNotNull();
	}
}
