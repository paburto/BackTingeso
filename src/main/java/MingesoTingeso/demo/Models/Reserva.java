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
    private String estado;

		@ManyToOne(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY)
		@JoinColumn(name = "idCliente")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Cliente cliente;

		@ManyToOne(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY)
		@JoinColumn(name = "idUser")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Usuario usuario;


		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "idReserva")
		@JsonIgnore
		private List<ReservaHabitacion> reservahabitaciones;



    public Reserva() {

    }

    public Reserva(String estado) {
        this.estado = estado;
    }

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva= idReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
