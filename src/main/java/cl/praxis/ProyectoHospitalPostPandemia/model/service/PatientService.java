package cl.praxis.ProyectoHospitalPostPandemia.model.service;

import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;

import java.util.List;

public interface PatientService {
    List<Paciente> getAll();
    Paciente getOne(int id);
    boolean create(Paciente p );
    boolean upDate(Paciente p);
    boolean delete(int id);
}
