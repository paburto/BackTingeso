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
@Table(name="cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Long idCliente;

    @Column(nullable = false, name = "`rut`")
    private int rut;

    @Column(nullable = false, name = "`nombreCliente`")
    private String nombreCliente;

    @Column(nullable = false, name = "`correoCliente`")
	private String correoCliente;

    @Column(nullable = false, name = "`telefono`")
    private int telefono;

    @Column(nullable = false, name = "`fechaNacimiento`")
    private Date fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private List<Reserva> reservas;

    @ManyToMany
    private Set<Registro> registros;

    public Cliente() {

    }

    public Cliente( int rut, String nombreCliente,String correoCliente, int telefono ,Date fechaNacimiento) {
    	this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdCliente() {
			return idCliente;
		}

	public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getTelefonoCliente() {
		return telefono;
	}

	public void setTelefonoCliente(int telefono) {
		this.telefono = telefono;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaVencimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
