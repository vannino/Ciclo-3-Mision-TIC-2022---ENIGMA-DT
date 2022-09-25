package enigmaDT.proyecto.thymeleaf.Repository;

import enigmaDT.proyecto.thymeleaf.Entity.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface IEmpresaRepository extends CrudRepository<Empresa,Long> {
}
