package pe.edu.cibertec.DAWI_CL1_Grupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo6.model.PracticaModel;

@Controller
public class practicaController {
    @GetMapping("/practica")
    public String Practica(Model model) {
        model.addAttribute("practica", new PracticaModel());
        return "practica";
    }

    @PostMapping("/calcularPractica")
    public String calcularPractica(@ModelAttribute("practica") PracticaModel practicaModel, Model model) {
        double[] notas = {practicaModel.getNota1(), practicaModel.getNota2(), practicaModel.getNota3(), practicaModel.getNota4()};
        double notaMinima = Double.MAX_VALUE;
        double suma = 0;

        // Encontrar la nota más baja
        for (double nota : notas) {
            if (nota < notaMinima) {
                notaMinima = nota;
            }
            suma += nota;
        }

        // Calcular el promedio eliminando la nota más baja
        double promedio = (suma - notaMinima) / 3;

        model.addAttribute("notaMinima", notaMinima);
        model.addAttribute("promedio", promedio);
        return "practica";
    }
}
