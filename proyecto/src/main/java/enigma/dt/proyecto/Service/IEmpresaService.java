package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public interface IEmpresaService {
    public Empresa findById(long id);

    public ArrayList<Empresa> findAll();

    public Empresa createEmpresa(Empresa empresa);

    public Empresa updateEmpresa(long id, Empresa empresa);

    public void deleteEmpresa( long id);
}
