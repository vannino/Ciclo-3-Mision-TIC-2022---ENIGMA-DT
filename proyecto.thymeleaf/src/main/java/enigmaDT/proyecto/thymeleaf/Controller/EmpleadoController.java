package enigmaDT.proyecto.thymeleaf.Controller;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import enigmaDT.proyecto.thymeleaf.Entity.Empresa;
import enigmaDT.proyecto.thymeleaf.Entity.MovimientoDinero;
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
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IEmpresaService empresaService;
    @Autowired
    private IMovimientoDineroService movimientoDineroService;

    private final Logger LOG = Logger.getLogger(""+EmpleadoController.class);

    @GetMapping("/empleados/list")
    public String getListEmpleados(Model model){
        LOG.log(Level.INFO,"getListEmpleados");
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados",empleados);
        return "empleados/list";
    }
    @GetMapping("/empleados/modificar")
    public String nuevoEmpleado(Model model){
        LOG.log(Level.INFO,"getListEmpleados");
        Empleado empleado = new Empleado();
        model.addAttribute("empleado",empleado);
        List<Empresa> empresas = empresaService.findAll();
        model.addAttribute("empresas",empresas);
        List<MovimientoDinero> transacciones = movimientoDineroService.findALL();
        model.addAttribute("transacciones",transacciones);
        return "empleados/modificar";
    }
    @PostMapping("/guardar")
    public String guardarEmpleado(@Valid Empleado empleado, BindingResult errors, Model model) {
        LOG.log(Level.INFO, "guardarEmpleado");
        if (empleado.getEmpresa().getIdEmpresa() == 0) {
            FieldError field = new FieldError("empleado", "empresa", "Campo obligatorio");
            errors.addError(field);
        }
        for (ObjectError e : errors.getAllErrors())
            System.out.println(e.toString());
        if (errors.hasErrors()) {
            List<Empresa> empresas = empresaService.findAll();
            model.addAttribute("empresas", empresas);
            return "empleados/modificar";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            empleado.setEstado(true);
            empleado.setPassword(encoder.encode(empleado.getPassword()));
            System.out.println(empleado.toString());
            empleadoService.createEmpleado(empleado);
            return "redirect:/empleados/list";
        }
    }

        @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
        public String editarEmpleado(@PathVariable("id") long id, Model model){
            LOG.log(Level.INFO,"editarUsuario");
            System.out.println(id);
            Empleado empleado = empleadoService.findById(id);
            model.addAttribute("empleado", empleado);
            List<Empresa> empresas = empresaService.findAll();
            model.addAttribute("empresas",empresas);
            return "empleados/modificar";
        }

        @RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
        public String eliminarEmpleado(@PathVariable("id") long id,Model modelo){
            LOG.log(Level.INFO,"eliminarUsuario");
            Empleado empleado = empleadoService.findById(id);
            empleado.setEstado(false);
            empleadoService.updateEmpleado(id,empleado);
            return "redirect:/empleados/list";
        }
    }

