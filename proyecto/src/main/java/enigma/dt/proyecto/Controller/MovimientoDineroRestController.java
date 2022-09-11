package enigma.dt.proyecto.Controller;

import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Entity.MovimientoDinero;
import enigma.dt.proyecto.Service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class MovimientoDineroRestController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @GetMapping("/movements")
    public List<MovimientoDinero> findALL(){
        return movimientoDineroService.findALL();
    }

    @GetMapping("/movements/{id}")
    public MovimientoDinero findById(@PathVariable long id){
        return movimientoDineroService.findByID(id);
    }

    @GetMapping("/{id}/movements")
    public List<MovimientoDinero> findAllByEnterprise(@PathVariable long id){
        return movimientoDineroService.findAll(id);
    }

    @PostMapping("/movements")
    public MovimientoDinero createTransaccion(@RequestBody MovimientoDinero transaccion){
        return movimientoDineroService.createTransaccion(transaccion);
    }

    @PutMapping("/{id}/movements")
    public MovimientoDinero updateTransaccion(@PathVariable long id, @RequestBody MovimientoDinero transaccion){
        return movimientoDineroService.updateTransaccion(id,transaccion);
    }

    @DeleteMapping("/{id}/movements")
    public void deleteTransaccion(@PathVariable long id){
        movimientoDineroService.deleteTransaccion(id);
    }
}
