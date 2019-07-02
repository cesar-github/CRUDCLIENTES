package main.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import main.model.Clientes;
import main.model.repository.IClientesDAO;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteTestAgregar {
	@Autowired
	TestEntityManager manager;

	@Autowired
	IClientesDAO dao;
	
	@Before
	public void setUp() throws Exception {
		
		Clientes cliente = new Clientes("1111111-1", "Roberto ", "Cofre", "robertocofre@example.cl", "+56998765412");
		this.manager.persist(cliente);
		
	}

	@Test
	public void cuandoInserta1EntoncesRetorna2Equipos() {
		this.dao.save(new Clientes("9999999-9", "Juan Toberto", "Gonzales Cofre", "juantoberto@hotmail.cl", "+56978974135"));
		int largo = this.dao.findAll().size();
		assertTrue("SON " + largo + " PERO DEBERÍAN SER 2", largo == 2);
	}

}
