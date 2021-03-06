package jpa.jpaEjemplo;




import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jpa.domain.Tcliente;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"jpa.controller"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	private static void insertarCliente() {
		Tcliente cliente = new Tcliente();
		cliente.setNombre("juan alejandro3");
		cliente.setApellido1("larrosa");
		cliente.setApellido2("pinar");
		cliente.setDni("48692239C");
		Date fecNac = obtenerFecha(28,04,1994);
		cliente.setFechaNacimiento(fecNac );
	}

	private static Date obtenerFecha(int dia, int mes, int anio) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH,mes-1);
		c.set(Calendar.YEAR, anio);
		return c.getTime();
	}

	
}
