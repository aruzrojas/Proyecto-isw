package hello.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="USUARIO")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name="ID_USUARIO")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="CORREO")
    private String correo;

    @Column(name="PASSWORD")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Rol> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
