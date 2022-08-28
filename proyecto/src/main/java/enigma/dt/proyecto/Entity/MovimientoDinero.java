package enigma.dt.proyecto.Entity;

import java.util.Date;

public class MovimientoDinero {
    private long id;
    private Double montoTransaccion;
    private String concepto;
    private Empleado empleado;
    private Empresa empresa;
    private Date fechaActualizacion;
    private Date fechaCreacion;

    public MovimientoDinero(long id, Double montoTransaccion, String concepto, Empleado empleado, Empresa empresa, Date fechaActualizacion, Date fechaCreacion) {
        this.id = id;
        this.montoTransaccion = montoTransaccion;
        this.concepto = concepto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
    }

    public MovimientoDinero(){

    }

    public Double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(Double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        return "MovimientoDinero{" +
                "id=" + id +
                ", montoTransaccion=" + montoTransaccion +
                ", concepto='" + concepto + '\'' +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
