package com.esfeasistencia.modelos;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Nombre es requerido")
    private String Nombre;
    @NotBlank(message = "Apellido es requerido")
    private String Apellido;
    @NotBlank(message = "Email es requerido")
    @Email(message = "La entrada no corresponde a un Email válido" )
    private String email;
    @NotBlank(message = "Teléfono es requerido")
    private String telefono;
    @NotBlank(message = "Escuela es requerido")
    private String escuela;

    @ManyToMany
    @JoinTable(
            name = "docentes_grupos",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private Set<Grupo> grupos = new HashSet<>();

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Nombre es requerido") String getNombre() {
        return Nombre;
    }

    public void setNombre(@NotBlank(message = "Nombre es requerido") String nombre) {
        Nombre = nombre;
    }

    public @NotBlank(message = "Apellido es requerido") String getApellido() {
        return Apellido;
    }

    public void setApellido(@NotBlank(message = "Apellido es requerido") String apellido) {
        Apellido = apellido;
    }

    public @NotBlank(message = "Email es requerido") @Email(message = "La entrada no corresponde a un Email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email es requerido") @Email(message = "La entrada no corresponde a un Email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Teléfono es requerido") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "Teléfono es requerido") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "Escuela es requerido") String getEscuela() {
        return escuela;
    }

    public void setEscuela(@NotBlank(message = "Escuela es requerido") String escuela) {
        this.escuela = escuela;
    }
}
