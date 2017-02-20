	package com.s4n.delivery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArchivoTest.class,
				EntregarDomicilioTest.class,
				EntregaTest.class,
				LimitesTest.class,
				ObtenerDispositvoTest.class,
				PosicionTest.class,
				ReporteTest.class,
				UtilidadesTest.class
			 })
public class AppAllTest {
	
}
