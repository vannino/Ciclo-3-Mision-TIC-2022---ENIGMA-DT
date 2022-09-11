package enigma.dt.proyecto;

import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Entity.MovimientoDinero;
import enigma.dt.proyecto.Entity.Rol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		System.out.println("OK");

	}

}
