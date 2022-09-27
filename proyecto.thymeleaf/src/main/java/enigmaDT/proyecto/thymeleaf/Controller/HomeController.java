package enigmaDT.proyecto.thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class HomeController {
    private final Logger LOG = Logger.getLogger(""+HomeController.class);

    @GetMapping("/")
    public String home(Model model){
        LOG.log(Level.INFO,"home");
        var mensaje= "Bienvenidos al Sistema de Enigma DT";
        model.addAttribute("mensaje",mensaje);
        return "home";
    }
}
