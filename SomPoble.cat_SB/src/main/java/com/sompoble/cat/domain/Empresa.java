package com.sompoble.cat.domain;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA")
    private Long idEmpresa;
    
    @OneToOne
    @JoinColumn(name="ID_EMPRESARIO", nullable = false)
    @NotNull
    private Empresario empresario;
    
    @Column(name = "CIF", nullable = false, length = 9) 
    @NotNull
    @Size(max = 9)
    private String cif;
    
    @Column(name = "NOMBRE", nullable = false, length = 100) 
    @NotNull
    @Size(max = 100)
    private String nombre;
        
    @Column(name = "DIRECCION", nullable = false, length = 255) 
    @NotNull
    @Size(max = 255)
    private String direccion;
    
    @Column(name = "HORARIO", nullable = false, length = 255) 
    @NotNull
    @Size(max = 255)
    private String horario;
    
    @Column(name = "FECHA_ALTA", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaAlta;

    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;

    @OneToMany(mappedBy = "empresa")
    private List<Reserva> reservas;
    
    @OneToMany(mappedBy = "empresa")
    private List<Servicio> servicios;
    
    @OneToMany(mappedBy = "empresa")
    private List<Horario> horarios;

    public Empresa() {
    }

    public Empresa(Empresario empresario, String cif, String nombre, String direccion, String horario) {
        this.empresario = empresario;
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public Empresario getEmpresario() {
        return empresario;
    }

    public void setEmpresario(Empresario empresario) {
        this.empresario = empresario;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}