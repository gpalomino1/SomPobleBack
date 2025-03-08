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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Column(name = "TIPO_USUARIO", nullable = false)
    @NotNull
    private String tipoUsuario;
    
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 255) 
    @NotNull
    @Size(max = 255)
    private String nombreUsuario;
    
    @Column(name = "CONTRASEÑA", nullable = false, length = 255) 
    @NotNull
    @Size(max = 255)
    private String contraseña;

    @Column(name = "FECHA_ALTA", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaAlta;

    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;
    
    //TODO: es importante revisar esta relacion ya que da error en el test y no veo el porque
    /*
    @OneToMany(mappedBy = "destinatario")
    private List<Notificacion> notificaciones;*/

    public Usuario() {
    }

    public Usuario (String tipoUsuario, String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}