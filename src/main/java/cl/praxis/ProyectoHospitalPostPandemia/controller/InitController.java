package cl.praxis.ProyectoHospitalPostPandemia.controller;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.service.PatientServiceImpl;
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

    @GetMapping
    public String home(){
        return "index";
    }

}
