package enigma.dt.proyecto.Service;

import enigma.dt.proyecto.Entity.Empresa;
import enigma.dt.proyecto.Repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class EmpresaService implements IEmpresaService{
    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public Empresa findById(long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    @Override
    public ArrayList<Empresa> findAll() {
        ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaRepository.findAll();
        return empresas;
    }

    @Override
    public Empresa createEmpresa(Empresa empresa) {
        Empresa newEmpresa = empresaRepository.save(empresa);
        return empresa;
    }

    @Override
    public Empresa updateEmpresa(long id, Empresa empresa) {
        empresaRepository.save(empresa);
        return empresa;
    }

    @Override
    public void deleteEmpresa(long id) {
        empresaRepository.deleteById(id);
    }
}
