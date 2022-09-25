package enigmaDT.proyecto.thymeleaf.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "transacciones")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private long id;

    @NotNull
    @Column(name = "monto")
    private Double montoTransaccion;

    @Column(name = "concepto")
    private String concepto;

    @ManyToOne
    @JoinColumn(name = "empleado")
    private Empleado empleado;

    @Column(name = "fecha_creacion")
    private Date fechaActualizacion;

    @Column(name = "fecha_actualizacion")
    private Date fechaCreacion;

    @Column(name="estado")
    private boolean estado;

    public MovimientoDinero(long id, Double montoTransaccion, String concepto, Empleado empleado, Date fechaActualizacion, Date fechaCreacion, boolean estado) {
        this.id = id;
        this.montoTransaccion = montoTransaccion;
        this.concepto = concepto;
        this.empleado = empleado;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id=" + id +
                ", montoTransaccion=" + montoTransaccion +
                ", concepto='" + concepto + '\'' +
                ", empleado=" + empleado +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaCreacion=" + fechaCreacion +
                ", estado=" + estado +
                '}';
    }
}
