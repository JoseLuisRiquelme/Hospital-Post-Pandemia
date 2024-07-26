package controller;

import model.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pacientes")
public class PatientsController {

    private final PatientServiceImpl service;

    @Autowired
    public PatientsController(PatientServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public String verPacientes(Model model){
     model.addAttribute("pacientes",service.getAll());
        return "pacientes";
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        model.addAttribute("paciente",service.getOne(id));
        return "detallesPaciente";
    }

}
