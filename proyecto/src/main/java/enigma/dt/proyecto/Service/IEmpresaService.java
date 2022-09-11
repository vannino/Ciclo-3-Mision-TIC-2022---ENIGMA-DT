package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public interface IEmpresaService {
    public Empresa findById(long id);

    public List<Empresa> findAll();

    public Empresa createEmpresa(Empresa empresa);

    public Empresa updateEmpresa(long id, Empresa empresa);

    public void deleteEmpresa( long id);
}
