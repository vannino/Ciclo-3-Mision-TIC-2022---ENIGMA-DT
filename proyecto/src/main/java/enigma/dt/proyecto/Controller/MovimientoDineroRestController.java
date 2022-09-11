package enigma.dt.proyecto.Controller;

import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Entity.MovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class MovimientoDineroRestController {
    @GetMapping("/{id}")
    public MovimientoDinero findById(@PathVariable long id){
        return null;
    }

    @GetMapping("")
    public ArrayList<MovimientoDinero> findAll(){
        return null;
    }

    @PostMapping("")
    public MovimientoDinero createTransaccion(@RequestBody MovimientoDinero transaccion){
        return null;
    }

    @PatchMapping("/{id}")
    public MovimientoDinero updateTransaccion(@PathVariable long id, @RequestBody MovimientoDinero transaccion){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTransaccion(@PathVariable long id){
    }
}
