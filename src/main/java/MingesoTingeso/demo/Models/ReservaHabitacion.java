package MingesoTingeso.demo.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@Entity
@Table(name="reservahabitacion")
public class ReservaHabitacion implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(nullable = false, name = "fechaInicio")
  private Date fechaInicio;

  @Column(nullable = false, name = "fechaTermino")
  private Date fechaTermino;

  @Column(name = "activa")
  private boolean activa;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(name = "idReserva")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Reserva reserva;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(name = "idHab")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Habitacion habitacion;


  public ReservaHabitacion(Date fechaInicio, Date fechaTermino, Reserva reserva, Habitacion habitacion ) {
    this.fechaInicio = fechaInicio;
    this.fechaTermino = fechaTermino;
    this.reserva = reserva;
    this.habitacion = habitacion;
    this.activa = true;
  }

  public ReservaHabitacion(){
    this.activa = true;
  }

  public Long getIdRH() {
    return id;
  }

  public void setIdRH(Long id) {
    this.id= id;
  }

  public Date getFechaInicioRH() {
    return fechaInicio;
  }

  public void setFechaInicioRH(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaTerminoRH() {
    return fechaTermino;
  }

  public void setFechaTerminoRH(Date fechaTermino) {
    this.fechaTermino = fechaTermino;
  }

  public Reserva getReserva(){
    return reserva;
  }

  public void setReserva(Reserva reserva){
    this.reserva = reserva;
  }

  public Habitacion getHabitacion(){
    return habitacion;
  }

  public void setHabitacion(Habitacion habitacion){
    this.habitacion = habitacion;
  }

  public boolean isActiva() {
    return activa;
  }

  public void setActiva(boolean activa) {
    this.activa = activa;
  }

}