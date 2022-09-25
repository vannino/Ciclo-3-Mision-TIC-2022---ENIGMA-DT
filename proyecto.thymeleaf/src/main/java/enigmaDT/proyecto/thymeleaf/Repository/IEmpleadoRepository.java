package enigmaDT.proyecto.thymeleaf.Repository;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
    Empleado findByUsername(String username);
}
