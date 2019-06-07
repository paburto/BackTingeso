package MingesoTingeso.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="comprobantePago")
public class ComprobantePago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "`total`")
    private Long total;

    @Column(nullable = false, name = "`detalle`")
    private String detalle;

    @Column(nullable = false, name = "`fecha`")
    private LocalDateTime fecha;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idRegistro")
    @JsonIgnore
    private Registro registro;

    public ComprobantePago(){

    }

    public ComprobantePago(Long total, String detalle, LocalDateTime fecha, Registro registro){
        this.total = total;
        this.detalle = detalle;
        this.fecha = fecha;
        this.registro = registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
