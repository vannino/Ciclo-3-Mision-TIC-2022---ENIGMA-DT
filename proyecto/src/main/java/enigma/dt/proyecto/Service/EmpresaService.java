package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Entity.MovimientoDinero;
import enigma.dt.proyecto.Repository.IEmpleadoRepository;
import enigma.dt.proyecto.Repository.IEmpresaRepository;
import enigma.dt.proyecto.Repository.IMovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaService{
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Autowired
    private IMovimientoDineroRepository movimientoDineroRepository;
    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public Empresa findById(long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    @Override
    public List<Empresa> findAll() {
        List<Empresa> empresas = (List<Empresa>) empresaRepository.findAll();
        return empresas;
    }

    @Override
    public Empresa createEmpresa(Empresa empresa) {
        Empresa newEmpresa = empresaRepository.save(empresa);
        return empresa;
    }

    @Override
    public Empresa updateEmpresa(long id, Empresa empresa) {
        Empresa updatedEmpresa = empresa;
        updatedEmpresa.setIdEmpresa(id);
        empresaRepository.save(updatedEmpresa);
        return updatedEmpresa;
    }

    @Override
    public void deleteEmpresa(long id) {
        List<MovimientoDinero> transacciones = (List<MovimientoDinero>) movimientoDineroRepository.findAll();
        for (MovimientoDinero transaccion: transacciones){
            if (transaccion.getEmpleado().getEmpresa().getIdEmpresa() == id){
                long id_transaccion = transaccion.getId();
                movimientoDineroRepository.deleteById(id_transaccion);
            }
        }
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        for (Empleado empleado: empleados){
            if (empleado.getEmpresa().getIdEmpresa() == id){
                long id_empleado = empleado.getId();
                empleadoRepository.deleteById(id_empleado);
            }
        }
        empresaRepository.deleteById(id);
    }
}
