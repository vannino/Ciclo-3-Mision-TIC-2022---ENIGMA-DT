package enigma.dt.proyecto.Repository;

import enigma.dt.proyecto.Entity.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface IEmpresaRepository extends CrudRepository<Empresa,Long> {
}
