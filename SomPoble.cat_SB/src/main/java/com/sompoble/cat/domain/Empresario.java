package com.sompoble.cat.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESARIO")
public class Empresario extends Persona{
    
    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuarioEmpresario;
    
    public Empresario() {
    }

    public Empresario(String dni, String nombre, String apellidos, String email, String telefono, Usuario usuarioEmpresario) {
        super(dni, nombre, apellidos, email, telefono);
        this.usuarioEmpresario = usuarioEmpresario;
    }
     public Usuario getUsuarioEmpresario() {
        return usuarioEmpresario;
    }

    public void setUsuarioEmpresario(Usuario usuarioEmpresario) {
        this.usuarioEmpresario = usuarioEmpresario;
    }   
}