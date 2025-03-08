
package com.sompoble.cat.domain;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "RESERVA")
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA")
    private Long idReserva;
    
    @ManyToOne
    @JoinColumn(name="ID_EMPRESA", referencedColumnName = "ID_EMPRESA", nullable = false)
    @NotNull
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", referencedColumnName = "ID", nullable = false)
    @NotNull
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="ID_SERVICIO", referencedColumnName = "ID_SERVICIO", nullable = false)
    @NotNull
    private Servicio servicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    @NotNull
    private Date fechaReserva;
    
    @Column(name = "HORA", nullable = false)
    @NotNull
    private LocalTime hora;
    
    @Column(name = "ESTADO", nullable = false, length = 50) 
    @NotNull
    @Size(max = 50)
    private String estado;
    
    @Column(name = "FECHA_ALTA", updatable = false, nullable = false)
    @CreationTimestamp
    @NotNull
    private LocalDateTime fechaAlta;

    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @UpdateTimestamp
    @NotNull
    private LocalDateTime fechaModificacion;

    public Reserva() {
    }

    public Reserva(Empresa empresa, Cliente cliente, Servicio servicio, Date fechaReserva, LocalTime hora, String estado) {
        this.empresa = empresa;
        this.cliente = cliente;
        this.servicio = servicio;
        this.fechaReserva = fechaReserva;
        this.hora = hora;
        this.estado = estado;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
}