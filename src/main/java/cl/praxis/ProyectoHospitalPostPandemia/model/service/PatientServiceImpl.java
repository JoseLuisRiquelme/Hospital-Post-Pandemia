package cl.praxis.ProyectoHospitalPostPandemia.model.service;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
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
        pacientes = new ArrayList<>();
        pacientes.add(new Paciente(1,"Pepe","Ito","su casa","111","https://ichef.bbci.co.uk/images/ic/640x360/p0gvfn2w.jpg"));
        pacientes.add(new Paciente(2,"Pluto","Niano","Un arbol","222","https://cdn11.bigcommerce.com/s-ydriczk/images/stencil/1500x1500/products/90489/99427/Disney-Baby-Pluto-Cardboard-Cutout-buy-now-at-starstills__12697.1710847981.jpg?c=2"));
        pacientes.add(new Paciente(3,"Minnie","Mouse","Disney World","333","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/678f8dce-2e4b-4959-af11-143c4d1b7c02/dg3w40h-76092642-aff0-44b1-96eb-dee60b11c0f7.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzY3OGY4ZGNlLTJlNGItNDk1OS1hZjExLTE0M2M0ZDFiN2MwMlwvZGczdzQwaC03NjA5MjY0Mi1hZmYwLTQ0YjEtOTZlYi1kZWU2MGIxMWMwZjcuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.VuF5usoV31M-TNA7OMH5P_e-DwQZpSijHBpjWbH1Ny8"));
        pacientes.add(new Paciente(4,"Donald ","Pato","EL lago","444","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlKvP60atKZemFrUIjaKty-qGhsRwj340faA&s"));
        pacientes.add(new Paciente(5,"Lucas","Pato","Los alpes","555","https://revistaparati.mx/wp-content/uploads/2023/08/captura-de-pantalla-2023-08-25-a-las-20.33.38.png?w=396"));
        pacientes.add(new Paciente(6,"Goku","San","Kame house","666","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/0b01937a-fbe0-4d3d-8b55-72d2f9b0968a/dgc7zwr-35b2fce4-d01e-4726-ad54-dd21aae15332.jpg/v1/fill/w_1280,h_1600,q_75,strp/goku_daima_by_salvamakoto_dgc7zwr-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTYwMCIsInBhdGgiOiJcL2ZcLzBiMDE5MzdhLWZiZTAtNGQzZC04YjU1LTcyZDJmOWIwOTY4YVwvZGdjN3p3ci0zNWIyZmNlNC1kMDFlLTQ3MjYtYWQ1NC1kZDIxYWFlMTUzMzIuanBnIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.JelfrLZ1ihQF0QPWuPE3rSsYvDFy26Zl8G-LhmDfAYI"));
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
        LOG.info("Called getOne():"+id);
        return pacientes
                .stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(Paciente p) {
        LOG.info("Called create() with patient 'p': "+p);
        pacientes.add(p);
        return true;
    }

    @Override
    public boolean upDate(Paciente p) {
        LOG.info("Called upDate() with patient 'p': "+p);
        Paciente pacienteUpDate = getOne(p.getId());
        pacienteUpDate.setId(p.getId());
        pacienteUpDate.setName(p.getName());
        pacienteUpDate.setLastName(p.getLastName());
        pacienteUpDate.setAddress(p.getAddress());
        pacienteUpDate.setPhone(p.getPhone());
        pacienteUpDate.setImage(p.getImage());
        return true;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Called delete() with  'id': "+id);
        Paciente p = getOne(id);
        if(p != null){
            pacientes.remove(p);
            return true;
        }
        return false;
    }
}
