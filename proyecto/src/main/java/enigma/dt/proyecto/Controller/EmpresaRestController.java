package enigma.dt.proyecto.Controller;


import enigma.dt.proyecto.Entity.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/enterprises")
public class EmpresaRestController {


    @GetMapping("/{id}")
    public Empresa findById(@PathVariable long id){
        return null;
    }

    @GetMapping("")
    public ArrayList<Empresa> findAll(){
        return null;
    }

    @PostMapping("")
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return null;
    }

    @PatchMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable long id, @RequestBody Empresa empresa){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable long id){
    }
}
