package controller;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import model.service.PatientService;
import model.service.PatientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pacientes.html")
public class PatientsController {

    private static final Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);
     PatientServiceImpl service;

    @Autowired
    public PatientsController(PatientServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public String verPacientes(Model model){
        LOG.info("Executing getAll() 'pacientes.html'");
     model.addAttribute("pacientes.html",service.getAll());
        return "pacientes.html";
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        LOG.info("Executing getOne with the {id}: "+id);
        model.addAttribute("paciente",service.getOne(id));
        return "detallesPaciente";
    }

}
