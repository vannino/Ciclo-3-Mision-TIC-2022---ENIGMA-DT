package enigmaDT.proyecto.thymeleaf.Service;


import enigmaDT.proyecto.thymeleaf.Entity.Empleado;
import enigmaDT.proyecto.thymeleaf.Repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserDetailsService")
public class LoginService implements UserDetailsService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado empleado = empleadoRepository.findByUsername(username);

        if (empleado==null){
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(empleado.getRol().toString()));

        return new User(empleado.getUsername(),empleado.getPassword(),roles);
    }
}