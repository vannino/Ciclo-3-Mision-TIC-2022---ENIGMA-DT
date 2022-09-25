package enigmaDT.proyecto.thymeleaf.Controller;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import enigmaDT.proyecto.thymeleaf.Entity.Empresa;
import enigmaDT.proyecto.thymeleaf.Service.IEmpleadoService;
import enigmaDT.proyecto.thymeleaf.Service.IEmpresaService;
import enigmaDT.proyecto.thymeleaf.Service.IMovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class EmpresasController {
    @Autowired
    private IEmpresaService empresaService;
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IMovimientoDineroService movimientoDineroService;

    private final Logger LOG = Logger.getLogger(""+EmpresasController.class);

    @GetMapping("/empresas/list")
    public String getListEmpresas(Model model){
        LOG.log(Level.INFO,"getListEmpresas");
        List<Empresa> empresas = empresaService.findAll();
        model.addAttribute("empresas",empresas);
        return "empresas/list";
    }
    @GetMapping("/empresas/modificar")
    public String editarEmpresa(Model model){
        LOG.log(Level.INFO,"editarEmpresa");
        Empresa empresa = new Empresa();
        model.addAttribute("empresa",empresa);
        return "empresas/modificar";
    }

    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(@Valid Empresa empresa, BindingResult errors, Model model) {
        LOG.log(Level.INFO, "guardarEmpresa");
        empresa.setEstado(true);
        System.out.println(empresa.toString());
        empresaService.createEmpresa(empresa);
        return "redirect:/empresas/list";
    }

    @RequestMapping(value = "/editarEmpresa/{id}", method = RequestMethod.GET)
    public String editarEmpresa(@PathVariable("id") long id, Model model){
        LOG.log(Level.INFO,"editarEmpresa");
        System.out.println(id);
        Empresa empresa = empresaService.findById(id);
        model.addAttribute("empresa", empresa);
        return "empresas/modificar";
    }

    @RequestMapping(value="/eliminarEmpresa/{id}", method = RequestMethod.GET)
    public String eliminarEmpresa(@PathVariable("id") long id,Model modelo){
        LOG.log(Level.INFO,"eliminarEmpresa");
        Empresa empresa = empresaService.findById(id);
        empresa.setEstado(false);
        empresaService.updateEmpresa(id,empresa);
        return "redirect:/empresas/list";
    }
}

