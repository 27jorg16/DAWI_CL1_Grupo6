package pe.edu.cibertec.DAWI_CL1_Grupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo6.model.TiempoModel;

@Controller
public class tiempoController {
    @GetMapping("/tiempo")
    public String Tiempo(Model model) {
        model.addAttribute("tiempoModel", new TiempoModel());
        return "tiempo";
    }

    @PostMapping("/calcularMinutos")
    public String calcularMinutos(@ModelAttribute("tiempoModel") TiempoModel tiempoModel, Model model) {
        int segundos = tiempoModel.getSegundos();
        int minutos = segundos / 60;

        model.addAttribute("minutos", minutos);
        return "tiempo";
    }
}
