package main.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteTestAgregar.class, ClienteTestEliminar.class, ClienteTestListar.class, ClienteTestListar1.class,
		ClienteTestModificar.class })
public class AllTests {

}
