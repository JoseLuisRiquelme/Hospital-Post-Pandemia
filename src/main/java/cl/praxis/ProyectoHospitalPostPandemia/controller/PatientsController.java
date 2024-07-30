package cl.praxis.ProyectoHospitalPostPandemia.controller;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.service.PatientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pacientes")
public class PatientsController {

    private static final Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);
    private PatientServiceImpl service;

    public PatientsController(PatientServiceImpl service) {
        this.service = service;
    }
    @GetMapping()
    public String verPacientes(Model model){
        LOG.info("Executing getAll() 'pacientes'");
     model.addAttribute("pacientes",service.getAll());
        return "pacientes2";
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        LOG.info("Executing getOne with the {id}: "+id);
        model.addAttribute("paciente",service.getOne(id));
        return "detallesPaciente";
    }

}
