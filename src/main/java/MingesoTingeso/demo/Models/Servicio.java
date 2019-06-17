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
@Table(name="servicio")
public class Servicio implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Long idServicio;

    @Column(nullable = false, name = "`descripcion`")
    private String descripcion;

    @Column(nullable = false, name = "`nombreServicio`")
    private String nombreServicio;

    @Column(nullable = false, name = "`precioServicio`")
    private int precioServicio;

		@Column(nullable = false, name = "`categoriaServicio`")
    private String categoriaServicio;

    public Servicio() {

    }

    public Servicio(String descripcion, String nombreServicio, int precioServicio, String categoriaServicio) {
        this.descripcion = descripcion;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
				this.categoriaServicio = categoriaServicio;
    }

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio= idServicio;
	}

	public String getDescripcionServicio() {
		return descripcion;
	}

	public void setDescripcionServicio(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public int getPrecio() {
		return precioServicio;
	}

	public void setPrecio(int precioServicio) {
		this.precioServicio = precioServicio;
	}

	public String getCategoriaServicio(){
		return categoriaServicio;
	}

	public void setCategoriaServicio(String categoriaServicio){
		this.categoriaServicio = categoriaServicio;
	}

}
