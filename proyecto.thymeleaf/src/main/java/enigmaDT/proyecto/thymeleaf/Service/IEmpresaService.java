package enigmaDT.proyecto.thymeleaf.Service;

import enigmaDT.proyecto.thymeleaf.Entity.Empresa;

import java.util.List;

public interface IEmpresaService {
    public Empresa findById(long id);

    public List<Empresa> findAll();

    public Empresa createEmpresa(Empresa empresa);

    public Empresa updateEmpresa(long id, Empresa empresa);

    public void deleteEmpresa( long id);
}
