package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.MovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public interface IMovimientoDineroService {

    public MovimientoDinero findByID(long id);

    public List<MovimientoDinero> findALL();

    public List<MovimientoDinero> findAll(long id);

    public MovimientoDinero createTransaccion(MovimientoDinero transaccion);

    public MovimientoDinero updateTransaccion(long id, MovimientoDinero transaccion);

    public void deleteTransaccion(long id);
}
