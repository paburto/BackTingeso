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
@Table(name="productos")
public class Producto implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "`nombreProducto`")
    private String nombreProducto;

    @Column(nullable = false, name = "`codigoProducto`")
    private int codigoProducto;

    @Column(nullable = false, name = "`categoria`")
    private String categoria;

    @Column(nullable = false, name = "`precio`")
    private int precio;

    @Column(nullable = false, name = "`fechaVencimiento`")
    private Date fechaVencimiento;

    public Producto() {

    }

    public Producto(String nombreProducto, String categoria, Date fechaVencimiento, int codigoProducto, int precio) {
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoProducto = codigoProducto;
        this.precio = precio;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
