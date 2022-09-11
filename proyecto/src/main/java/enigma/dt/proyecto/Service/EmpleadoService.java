package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public Empleado findById(long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.get();
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        return empleados;
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        Empleado newEmpleado = empleadoRepository.save(empleado);
        return empleado;
    }

    @Override
    public Empleado updateEmpleado(long id, Empleado empleado) {
        Empleado updatedEmpleado = empleado;
        updatedEmpleado.setId(id);
        empleadoRepository.save(updatedEmpleado);
        return updatedEmpleado;
    }

    @Override
    public void deleteEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }
}
