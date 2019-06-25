package MingesoTingeso.demo.Models;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="historial")
public class Historial implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHis")
    private Long idHis;

    @Column(nullable = false, name = "`descripcion`")
    private String descripcion;

    @Column(nullable = false, name = "`fecha`")
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    public Historial() {

    }

    public Historial(String descripcion, LocalDate fecha, Usuario usuario){
      this.descripcion = descripcion;
      this.fecha = fecha;
      this.usuario = usuario;
    }

    public Long getIdHis() {
        return idHis;
    }

    public void setIdHis(Long idHis) {
        this.idHis = idHis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
