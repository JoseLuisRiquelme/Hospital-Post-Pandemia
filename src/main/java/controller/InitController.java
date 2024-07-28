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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InitController {
    private static final Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);
    @Autowired
    PatientServiceImpl service;

    /*public InitController(PatientServiceImpl service) {
        this.service = service;
    }*/

    @GetMapping
    public String home(Model model){
        LOG.info("Executing getAll() 'index.html'");
        model.addAttribute("pacientes",service.getAll());

        return "index";
    }
   /* @RequestMapping("/pacientes")
    public String verPacientes(Model model){
        LOG.info("Executing getAll() 'index.html'");
        model.addAttribute("pacientes",service.getAll());
        return "pacientes";
    }*/
}
