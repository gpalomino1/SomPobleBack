package com.sompoble.cat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Persona {
   
    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @NotNull
    private Usuario usuarioCliente;
    
    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, String email, String telefono, Usuario usuarioCliente) {
        super(dni, nombre, apellidos, email, telefono);
        this.usuarioCliente = usuarioCliente;
    }
    
     public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
}