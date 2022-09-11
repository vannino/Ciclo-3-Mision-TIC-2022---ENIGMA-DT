package enigma.dt.proyecto.Repository;

import enigma.dt.proyecto.Entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoRepository extends CrudRepository<Empleado,Long> {
}
