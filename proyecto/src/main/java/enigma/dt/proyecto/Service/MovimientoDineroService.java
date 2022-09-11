package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.MovimientoDinero;
import enigma.dt.proyecto.Repository.IMovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService implements IMovimientoDineroService{
    @Autowired
    private IMovimientoDineroRepository movimientoDineroRepository;

    @Override
    public MovimientoDinero findByID(long id) {
        Optional<MovimientoDinero> transaccion = movimientoDineroRepository.findById(id);
        return transaccion.get();
    }

    @Override
    public List<MovimientoDinero> findALL() {
        List<MovimientoDinero> transaccion = (List<MovimientoDinero>) movimientoDineroRepository.findAll();
        return transaccion;
    }

    @Override
    public List<MovimientoDinero> findAll(long id) {
        List<MovimientoDinero> transacciones = (List<MovimientoDinero>) movimientoDineroRepository.findAll();
        List<MovimientoDinero> transaccionesEmpresa = new ArrayList<MovimientoDinero>();
        for (MovimientoDinero transaccion: transacciones){
            if (transaccion.getEmpleado().getEmpresa().getIdEmpresa() == id){
                transaccionesEmpresa.add(transaccion);
            }
            System.out.println(transaccion);
        }
        return transaccionesEmpresa;
    }

    @Override
    public MovimientoDinero createTransaccion(MovimientoDinero transaccion) {
        MovimientoDinero newTransaccion = movimientoDineroRepository.save(transaccion);
        return transaccion;
    }

    @Override
    public MovimientoDinero updateTransaccion(long id, MovimientoDinero transaccion) {
        MovimientoDinero updatedTransaccion = transaccion;
        updatedTransaccion.setId(id);
        movimientoDineroRepository.save(updatedTransaccion);
        return updatedTransaccion;
    }

    @Override
    public void deleteTransaccion(long id) {
        movimientoDineroRepository.deleteById(id);
    }
}
