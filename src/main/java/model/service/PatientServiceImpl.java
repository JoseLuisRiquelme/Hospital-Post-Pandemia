package model.service;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import model.dto.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientServiceImpl implements PatientService{

    private static final Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);

    private List<Paciente> pacientes;

    public PatientServiceImpl() {
        pacientes = new ArrayList<Paciente>();
        pacientes.add(new Paciente(1,"Pepe","Ito","su casa","555"));
        pacientes.add(new Paciente(2,"Pluto","Niano","su casa","555"));
        pacientes.add(new Paciente(3,"Minie","Mouse","su casa","555"));
        pacientes.add(new Paciente(4,"Donald ","Pato","su casa","555"));
        pacientes.add(new Paciente(5,"Lucas","Pato","su casa","555"));
    }

    public PatientServiceImpl(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public List<Paciente> getAll() {
        LOG.info("Called getAll()");
        return pacientes;
    }

    @Override
    public Paciente getOne(int id) {
        LOG.info("Called getOne():",id);
        return pacientes
                .stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(Paciente p) {
        LOG.info("Called create() with patient 'p':",p);
        pacientes.add(p);
        return true;
    }

    @Override
    public boolean upDate(Paciente p) {
        LOG.info("Called upDate() with patient 'p':",p);
        return false;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Called delete() with  'id':",id);
        return false;
    }
}
