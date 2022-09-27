package enigmaDT.proyecto.thymeleaf.Service;

import enigmaDT.proyecto.thymeleaf.Entity.MovimientoDinero;

import java.util.List;

public interface IMovimientoDineroService {

    public MovimientoDinero findById(long id);

    public List<MovimientoDinero> findALL();

    public List<MovimientoDinero> findAll(long id);

    public MovimientoDinero createTransaccion(MovimientoDinero transaccion);

    public MovimientoDinero updateTransaccion(long id, MovimientoDinero transaccion);

    public void deleteTransaccion(long id);
}
