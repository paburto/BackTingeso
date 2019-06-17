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
@Table(name="registro")
public class Registro implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro")
    private Long idRegistro;

    @Column(name = "representante", nullable = true)
    private String representante;

    @Column(nullable = false, name = "fechaInicio")
    private Date fechaInicio;

    @Column(nullable = false, name = "fechaTermino")
    private Date fechaTermino;

	@Column(name = "precio")
	private Integer precio;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idHab")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Habitacion habitacion;

    public Registro() {

    }

    public Registro(String representante, Date fechaInicio,  Date fechaTermino, Habitacion habitacion) {
        this.representante = representante;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.habitacion = habitacion;
    }

	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante= representante;
	}

	public Date getFechaInicio(){
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaTermino(){
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Habitacion getHabitacion(){
    	return habitacion;
	}

	public void setHabitacion(Habitacion habitacion){
    	this.habitacion = habitacion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
