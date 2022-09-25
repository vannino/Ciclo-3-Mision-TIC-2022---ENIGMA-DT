package enigmaDT.proyecto.thymeleaf.Service;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public Empleado findById(long id);

    public List<Empleado> findAll();

    public Empleado createEmpleado(Empleado empleado);

    public Empleado updateEmpleado(long id, Empleado empleado);

    public void deleteEmpleado(long id);
}
