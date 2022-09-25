package enigmaDT.proyecto.thymeleaf.Service;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import enigmaDT.proyecto.thymeleaf.Entity.MovimientoDinero;
import enigmaDT.proyecto.thymeleaf.Repository.IEmpleadoRepository;
import enigmaDT.proyecto.thymeleaf.Repository.IMovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IMovimientoDineroRepository movimientoDineroRepository;

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
        List<MovimientoDinero> transacciones = (List<MovimientoDinero>) movimientoDineroRepository.findAll();
        for (MovimientoDinero transaccion: transacciones){
            if (transaccion.getEmpleado().getId() == id){
                long id_transaccion = transaccion.getId();
                movimientoDineroRepository.deleteById(id_transaccion);
            }
        }
        empleadoRepository.deleteById(id);
    }
}
