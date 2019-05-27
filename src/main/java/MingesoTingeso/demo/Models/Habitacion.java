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
@Table(name="habitacion")
public class Habitacion implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHab")
    private Long idHab;

		@Column(name = "nroHabitacion")
		private int nroHabitacion;

    @Column(nullable = false, name = "`tipo`")
    private String tipo;

    @Column(nullable = false, name = "`capacidadNinos`")
    private int capacidadNinos;

    @Column(nullable = false, name = "`capacidadAdultos`")
    private int capacidadAdultos;

    @Column(nullable = false, name = "`precioNoche`")
    private int precioNoche;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idHab")
    @JsonIgnore
    private List<Registro> registros;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idHab")
    @JsonIgnore
    private List<ReservaHabitacion> reservahabitaciones;


    public Habitacion() {

    }

    public Habitacion(String tipo, int nroHabitacion, int capacidadNinos,int capacidadAdultos, int precioNoche) {
        this.tipo = tipo;
				this.nroHabitacion= nroHabitacion;
        this.capacidadNinos = capacidadNinos;
        this.capacidadAdultos = capacidadAdultos;
        this.precioNoche = precioNoche;
    }

	public Long getIdHabitacion() {
		return idHab;
	}

	public void setIdHabitacion(Long idHab) {
		this.idHab= idHab;
	}

	public int getNroHabitacion(){
		return nroHabitacion;
	}

	public void setNroHabitacion(int nroHabitacion){
		this.nroHabitacion= nroHabitacion;
	}

	public String getTipoHabitacion() {
		return tipo;
	}

	public void setTipoHabitacion(String tipo) {
		this.tipo= tipo;
	}

	public int getCapacidadNinos() {
		return capacidadNinos;
	}

	public void setCapacidadNinos(int capacidadNinos) {
		this.capacidadNinos = capacidadNinos;
	}

	public int getCapacidadAdultos() {
		return capacidadAdultos;
	}

	public void setCapacidadAdultos(int capacidadAdultos) {
		this.capacidadAdultos = capacidadAdultos;
	}
  public int getPrecioNoche() {
    return precioNoche;
  }

  public void setPrecioNoche(int precioNoche) {
    this.precioNoche = precioNoche;
  }

	@JsonIgnore
	public List<ReservaHabitacion> getReservasHabitaciones() {
		return reservahabitaciones;
	}
	@JsonIgnore
	public void setReservasHabitaciones(List<ReservaHabitacion> reservahabitaciones) {
			this.reservahabitaciones = reservahabitaciones;
	}

}
