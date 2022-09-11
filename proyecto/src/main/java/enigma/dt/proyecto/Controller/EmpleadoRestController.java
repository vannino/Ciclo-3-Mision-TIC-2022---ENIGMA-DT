package enigma.dt.proyecto.Controller;


import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Entity.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")

public class EmpleadoRestController {
    @GetMapping("/{id}")
    public Empleado findById(@PathVariable long id){
        return null;
    }

    @GetMapping("")
    public ArrayList<Empleado> findAll(){
        return null;
    }

    @PostMapping("")
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return null;
    }

    @PatchMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable long id, @RequestBody Empleado empleado){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable long id){
    }

}
