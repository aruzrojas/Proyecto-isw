package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ROL")
public class Rol {
    @Id
    @GeneratedValue
    @Column(name="ID_ROL")
    private Long id;

    @Column(name="NOMBRE")
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
