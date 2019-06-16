package MingesoTingeso.demo.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="registro_servicio")
public class RegistroServicio implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(name = "idRegistro")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Registro registro;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(name = "idServicio")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Servicio servicio;

  public RegistroServicio(Registro registro, Servicio servicio) {
    this.registro = registro;
    this.servicio = servicio;
  }
  public RegistroServicio(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id= id;
  }

  public Servicio getServicio() {
    return servicio;
  }

  public void setServicio(Servicio servicio) {
    this.servicio = servicio;
  }

  public Registro getRegistro() {
    return registro;
  }

  public void setRegistro(Registro registro) {
    this.registro = registro;
  }
}
