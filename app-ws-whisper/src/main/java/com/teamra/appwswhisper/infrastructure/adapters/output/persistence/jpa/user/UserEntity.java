package com.teamra.appwswhisper.infrastructure.adapters.output.persistence.jpa.user;

import java.io.Serializable;
import java.util.Date;

import com.teamra.appwswhisper.domain.users.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;
    private String usuario;
    private String contrasenia;
    private String nombres;
    private String apellidos;
    private String correo;
    private String estado;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    public UserEntity() {
    }

    public UserEntity(Integer idUsuario, String usuario, String contrasenia, String nombres, String apellidos, String correo,
            String estado, Date fechaCreacion) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public UserEntity(User user){
        this.idUsuario = user.getIdUsuario();
        this.usuario = user.getUsuario();
        this.contrasenia = user.getContrasenia();
        this.nombres = user.getNombres();
        this.apellidos = user.getApellidos();
        this.correo = user.getCorreo();
        this.estado = user.getEstado();
        this.fechaCreacion = user.getFechaCreacion();
    }

    public User toUser(){
        User user = new User(idUsuario, usuario,  contrasenia,  nombres,  apellidos,  correo,
             estado,  fechaCreacion);
        return user;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    
}
