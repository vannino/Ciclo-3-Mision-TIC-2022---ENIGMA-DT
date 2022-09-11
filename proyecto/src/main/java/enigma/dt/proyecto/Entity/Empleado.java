package enigma.dt.proyecto.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id;

    @Column(name = "correo_empleado")
    private String correoEmpleado;

    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @JoinColumn(name = "rol_empleado")
    private Rol rol;

    @OneToMany
    @JoinColumn(name = "transacciones")
    private List<MovimientoDinero> transacciones;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;


    public Empleado(long id, String correoEmpleado, String nombreEmpleado, Empresa empresa, Rol rol, List<MovimientoDinero> transacciones, Date fechaActualizacion, Date fechaCreacion) {
        this.id = id;
        this.correoEmpleado = correoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.empresa = empresa;
        this.rol = rol;
        this.transacciones = transacciones;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
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

    public List<MovimientoDinero> getTransacciones() {
        return transacciones;
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

    public void setTransacciones(List<MovimientoDinero> transacciones) {
        this.transacciones = transacciones;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", empresa=" + empresa +
                ", rol=" + rol +
                ", transacciones=" + transacciones +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}