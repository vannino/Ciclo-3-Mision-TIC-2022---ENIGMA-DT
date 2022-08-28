package enigma.dt.proyecto.Entity;

import java.util.Date;

public class Empleado {
    private long id;
    private String correoEmpleado;
    private String nombreEmpleado;
    private Empresa empresa;
    private Rol rol;
    private MovimientoDinero transacciones;
    private Date fechaActualizacion;
    private Date fechaCreacion;

    public Empleado(long id, String correoEmpleado, String nombreEmpleado, Empresa empresa, Rol rol, MovimientoDinero transacciones, Date fechaActualizacion, Date fechaCreacion) {
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

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MovimientoDinero getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(MovimientoDinero transacciones) {
        this.transacciones = transacciones;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
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
