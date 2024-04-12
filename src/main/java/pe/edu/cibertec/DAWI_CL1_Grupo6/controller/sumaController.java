package pe.edu.cibertec.DAWI_CL1_Grupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo6.model.SumaModel;

@Controller
public class sumaController {
    @GetMapping("/suma")
    public String Suma(Model model) {
        model.addAttribute("numeroLimite", new SumaModel());
        return "suma";
    }

    @PostMapping("/calcularSuma")
    public String calcularSuma(@ModelAttribute("numeroLimite") SumaModel numeroLimite, Model model) {
        int limite = numeroLimite.getLimite();
        int suma = 0;

        // Calcular la suma de todos los números de la serie hasta el límite dado
        for (int i = 1; i <= limite; i++) {
            suma += i;
        }

        model.addAttribute("suma", suma);
        return "suma";
    }
}
