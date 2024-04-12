package pe.edu.cibertec.DAWI_CL1_Grupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class salarioController {
    @GetMapping("/salario")
    public String Salario() {
        return "salario";
    }

    @PostMapping("/calcularSalario")
    public String calcularSalario(@RequestParam int horasTrabajadas, Model model) {
        double salarioSemanal;
        double tarifaHoraRegular = 16;
        double tarifaHoraExtra = 20;
        int horasRegulares = 40;

        if (horasTrabajadas <= horasRegulares) {
            salarioSemanal = horasTrabajadas * tarifaHoraRegular;
        } else {
            int horasExtra = horasTrabajadas - horasRegulares;
            salarioSemanal = horasRegulares * tarifaHoraRegular + horasExtra * tarifaHoraExtra;
        }

        model.addAttribute("salarioSemanal", salarioSemanal);
        return "salario";
    }
}