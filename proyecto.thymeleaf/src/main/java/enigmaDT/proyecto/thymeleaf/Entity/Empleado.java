package enigmaDT.proyecto.thymeleaf.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id;

    @Pattern(regexp = "[a-zA-Z0-9!#$%&'*_+-]([\\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\\/()=?¿!.,:;]|\\d)+[a-zA-Z0-9][\\.][a-zA-Z]{2,4}([\\.][a-zA-Z]{2})?" ,message = "Debe ser un correo electrónico válido")
    @NotEmpty
    @Column(name = "correo_empleado")
    private String correoEmpleado;

    @NotEmpty
    @Column(name="Username")
    private String username;

    @NotEmpty
    @Column(name="Password")
    private String password;

    @NotEmpty
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @NotNull
    @JoinColumn(name = "rol_empleado")
    private Rol rol;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name="estado")
    private boolean estado;


    public Empleado(long id, String correoEmpleado, String username, String password, String nombreEmpleado, Empresa empresa, Rol rol, Date fechaActualizacion, Date fechaCreacion, boolean estado) {
        this.id = id;
        this.correoEmpleado = correoEmpleado;
        this.username = username;
        this.password = password;
        this.nombreEmpleado = nombreEmpleado;
        this.empresa = empresa;
        this.rol = rol;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
        this.estado= estado;
    }

    public Empleado() {
    }

    public long getId() {
        return id;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", empresa=" + empresa +
                ", rol=" + rol +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaCreacion=" + fechaCreacion +
                ", estado=" + estado +
                '}';
    }
}