package enigma.dt.proyecto.Controller;


import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Service.EmpresaService;
import enigma.dt.proyecto.Service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EmpresaRestController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable long id){
        return empresaService.findById(id);
    }

    @GetMapping("")
    public List<Empresa> findAll(){
        return empresaService.findAll();
    }

    @PostMapping("")
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.createEmpresa(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable long id, @RequestBody Empresa empresa){
        return empresaService.updateEmpresa(id,empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable long id){
        empresaService.deleteEmpresa(id);
    }
}
