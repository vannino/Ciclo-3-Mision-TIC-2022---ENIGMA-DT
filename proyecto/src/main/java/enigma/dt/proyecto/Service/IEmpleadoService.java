package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empleado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public interface IEmpleadoService {
    public Empleado findById(long id);

    public ArrayList<Empleado> findAll();

    public Empleado createEmpleado(Empleado empleado);

    public Empleado updateEmpleado(long id, Empleado empleado);

    public void deleteEmpleado(long id);
}
