package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.MovimientoDinero;
import enigma.dt.proyecto.Repository.IMovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class MovimientoDineroService implements IMovimientoDineroService{
    @Autowired
    private IMovimientoDineroRepository movimientoDineroRepository;

    @Override
    public MovimientoDinero findById(long id) {
        Optional<MovimientoDinero> transaccion = movimientoDineroRepository.findById(id);
        return transaccion.get();
    }

    @Override
    public ArrayList<MovimientoDinero> findAll() {
        ArrayList<MovimientoDinero> transacciones = (ArrayList<MovimientoDinero>) movimientoDineroRepository.findAll();
        return transacciones;
    }

    @Override
    public MovimientoDinero createTransaccion(MovimientoDinero transaccion) {
        MovimientoDinero newTransaccion = movimientoDineroRepository.save(transaccion);
        return transaccion;
    }

    @Override
    public MovimientoDinero updateTransaccion(long id, MovimientoDinero transaccion) {
        movimientoDineroRepository.save(transaccion);
        return transaccion;
    }

    @Override
    public void deleteTransaccion(long id) {
        movimientoDineroRepository.deleteById(id);
    }
}
