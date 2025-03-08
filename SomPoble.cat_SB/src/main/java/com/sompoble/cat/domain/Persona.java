package com.sompoble.cat.domain;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Long idPersona;
    
    @Column(name = "DNI", nullable = false, length = 9) 
    @NotNull
    @Size(min = 9, max = 9)
    private String dni;
    
    @Column(name = "NOMBRE", nullable = false, length = 100) 
    @NotNull
    @Size(max = 100)
    private String nombre;
    
    @Column(name = "APELLIDOS", nullable = false, length = 100) 
    @NotNull
    @Size(max = 100)
    private String apellidos;
    
    @Column(name = "EMAIL", nullable = false, length = 100) 
    @NotNull
    @Size(max = 100)
    private String email;
    
    @Column(name = "TELEFONO", nullable = false, length = 20) 
    @NotNull
    @Size(max = 20)
    private String telefono;   
    
    @Column(name = "FECHA_ALTA", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaAlta;

    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellidos, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Long getIdPersona() {
        return idPersona;
    }
    
    public String getNif() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public LocalDateTime getFechaAlta() {
       return fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
} 