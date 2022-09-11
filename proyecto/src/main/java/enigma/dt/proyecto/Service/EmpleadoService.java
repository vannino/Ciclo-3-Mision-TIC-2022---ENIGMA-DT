package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public Empleado findById(long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.get();
    }

    @Override
    public ArrayList<Empleado> findAll() {
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) empleadoRepository.findAll();
        return empleados;
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        Empleado newEmpleado = empleadoRepository.save(empleado);
        return empleado;
    }

    @Override
    public Empleado updateEmpleado(long id, Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleado;
    }

    @Override
    public void deleteEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }
}
