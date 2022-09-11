package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.MovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public interface IMovimientoDineroService {

    public MovimientoDinero findById(long id);

    public ArrayList<MovimientoDinero> findAll();

    public MovimientoDinero createTransaccion(MovimientoDinero transaccion);

    public MovimientoDinero updateTransaccion(long id, MovimientoDinero transaccion);

    public void deleteTransaccion(long id);
}
