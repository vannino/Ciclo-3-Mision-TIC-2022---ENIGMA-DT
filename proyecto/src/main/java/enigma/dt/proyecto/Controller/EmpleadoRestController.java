package enigma.dt.proyecto.Controller;


import enigma.dt.proyecto.Entity.Empleado;
import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Service.EmpleadoService;
import enigma.dt.proyecto.Service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")

public class EmpleadoRestController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/{id}")
    public Empleado findById(@PathVariable long id){
        return empleadoService.findById(id);
    }

    @GetMapping("/all/")
    public List<Empleado> findAll(){
        return empleadoService.findAll();
    }

    @PostMapping("")
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable long id, @RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(id,empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable long id){
        empleadoService.deleteEmpleado(id);
    }

}
