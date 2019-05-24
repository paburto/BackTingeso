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
@Table(name="reserva")
public class Reserva implements Serializable {

		@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long idReserva;

    @Column(nullable = false, name = "`estado`")
    private int estado;

		@Column(name = "`descuento`")
		private int descuento;

		@ManyToOne(	fetch = FetchType.LAZY)
		@JoinColumn(name = "idCliente")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Cliente cliente;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "idUser")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Usuario usuario;


		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "idReserva")
		@JsonIgnore
		private List<ReservaHabitacion> reservahabitaciones;



    public Reserva() {

    }

    public Reserva(int estado, int descuento) {
        this.estado = estado;
				this.descuento = descuento;
    }

	public Long getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Long idReserva) {
		this.idReserva= idReserva;
	}

	public int getDescuento(){
		return descuento;
	}

	public void setDescuento(int descuento){
		this.descuento = descuento;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	public Usuario getUsuario(){
		return usuario;
	}

	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

}
