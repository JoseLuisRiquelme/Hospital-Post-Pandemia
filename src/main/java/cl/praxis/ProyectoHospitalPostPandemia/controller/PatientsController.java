package cl.praxis.ProyectoHospitalPostPandemia.controller;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
import cl.praxis.ProyectoHospitalPostPandemia.model.service.PatientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacientes")
public class PatientsController {

    private static final Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);
    private PatientServiceImpl service;

    public PatientsController(PatientServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String verPacientes(Model model) {
        LOG.info("Executing getAll() 'pacientes'");
        model.addAttribute("pacientes", service.getAll());
        return "pacientes2";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model) {
        LOG.info("Executing getOne with the {id}: " + id);
        model.addAttribute("patient", service.getOne(id));
        return "editPatient";
    }

    @PostMapping
    public String upDate(@ModelAttribute Paciente p) {
        boolean result = service.upDate(p);

        if (result) {
            LOG.info("Paciente "+p.getName()+" actualizado correctamente");
        } else {
            LOG.error("Error al actualizar el paciente" + p.getName());
        }
        return "redirect:/pacientes";
    }

    @GetMapping("/new")
    public ModelAndView create() {
        return new ModelAndView("newPatient");
    }
    @PostMapping("/new")
    public String save(@ModelAttribute Paciente p){
        boolean result = service.create(p);
        if(result){
            LOG.info("Paciente "+p.getName()+" ingresado correctamente");
        }else {
            LOG.error("Error al ingresar el paciente "+p.getName());
        }
        return "redirect:/pacientes";
    }
    @GetMapping("/del/{id}")
    public  String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        if (result){
            LOG.info("Paciente con el id "+id+" elimimando correctamente");
        }else {
            LOG.error("Error al elimina el paciente con el id "+id);
        }
        return "redirect:/pacientes";
    }
}

