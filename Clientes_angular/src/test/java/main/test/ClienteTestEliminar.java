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
public class ClienteTestEliminar {
	@Autowired
	TestEntityManager manager;

	@Autowired
	IClientesDAO dao;
	@Before
	public void setUp() throws Exception {
		Clientes cliente = new Clientes("1111111-1", "Cesar 1", "Cofre 1", "example@example.cl", "+561111111");
		this.manager.persist(cliente);
		cliente = new Clientes("1111111-2", "Cesar 2", "Cofre 2", "example@example.cl", "+561111112");
		this.manager.persist(cliente);
		cliente = new Clientes("1111111-3", "Cesar 3", "Cofre 3", "example@example.cl", "+561111113");
		this.manager.persist(cliente);
		cliente = new Clientes("1111111-4", "Cesar 4", "Cofre 4", "example@example.cl", "+561111114");
		this.manager.persist(cliente);
		cliente = new Clientes("1111111-5", "Cesar 5", "Cofre 5", "example@example.cl", "+561111115");
		this.manager.persist(cliente);
	}

	@Test
	public void cuandoElimina1EntoncesRetorna4Clientes() {
		this.dao.deleteById("1111111-3");
		int largo = this.dao.findAll().size();
		assertTrue("SON " + largo + " PERO DEBERÍAN SER 4", largo == 4);
	}

}
