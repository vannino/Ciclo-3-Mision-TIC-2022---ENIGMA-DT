package enigmaDT.proyecto.thymeleaf.Controller;

import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import enigmaDT.proyecto.thymeleaf.Entity.Empresa;
import enigmaDT.proyecto.thymeleaf.Entity.MovimientoDinero;
import enigmaDT.proyecto.thymeleaf.Service.IEmpleadoService;
import enigmaDT.proyecto.thymeleaf.Service.IEmpresaService;
import enigmaDT.proyecto.thymeleaf.Service.IMovimientoDineroService;
import enigmaDT.proyecto.thymeleaf.Service.MovimientoDineroService;
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
public class TransaccionesController {
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IEmpresaService empresaService;
    @Autowired
    private IMovimientoDineroService movimientoDineroService;

    private final Logger LOG = Logger.getLogger(""+TransaccionesController.class);

    @GetMapping("/transacciones/list")
    public String getListTransacciones(Model model){
        LOG.log(Level.INFO,"getListTransacciones");
        List<MovimientoDinero> transacciones = movimientoDineroService.findALL();
        model.addAttribute("transacciones",transacciones);
        return "transacciones/list";
    }
    @GetMapping("/transacciones/modificar")
    public String modificarTransaccion(Model model){
        LOG.log(Level.INFO,"modificarTransaccion");
        MovimientoDinero transaccion = new MovimientoDinero();
        model.addAttribute("transaccion",transaccion);
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados",empleados);
        return "transacciones/modificar";
    }
    @PostMapping("/guardarTransaccion")
    public String guardarTransaccion(@Valid MovimientoDinero transaccion, BindingResult errors, Model model) {
        LOG.log(Level.INFO, "guardarTransaccion");
        if (transaccion.getEmpleado().getId() == 0) {
            FieldError field = new FieldError("transaccion", "empleado", "Campo obligatorio");
            errors.addError(field);
        }
        for (ObjectError e : errors.getAllErrors())
            System.out.println(e.toString());
        if (errors.hasErrors()) {
            List<Empleado> empleados = empleadoService.findAll();
            model.addAttribute("empleados",empleados);
            return "transacciones/modificar";
        } else {
            transaccion.setEstado(true);
            System.out.println(transaccion.toString());
            movimientoDineroService.createTransaccion(transaccion);
            return "redirect:/transacciones/list";
        }
    }

    @RequestMapping(value = "/editarTransaccion/{id}", method = RequestMethod.GET)
    public String editarTransaccion(@PathVariable("id") long id, Model model){
        LOG.log(Level.INFO,"editarTransaccion");
        System.out.println(id);
        MovimientoDinero transaccion = movimientoDineroService.findById(id);
        model.addAttribute("transaccion", transaccion);
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados",empleados);
        return "transacciones/modificar";
    }

    @RequestMapping(value="/eliminarTransaccion/{id}", method = RequestMethod.GET)
    public String eliminarTransaccion(@PathVariable("id") long id,Model modelo){
        LOG.log(Level.INFO,"eliminarTransaccion");
        MovimientoDinero transaccion = movimientoDineroService.findById(id);
        transaccion.setEstado(false);
        movimientoDineroService.updateTransaccion(id,transaccion);
        return "redirect:/transacciones/list";
    }
}

