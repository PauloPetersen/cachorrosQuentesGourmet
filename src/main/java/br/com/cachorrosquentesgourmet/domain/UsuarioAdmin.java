package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;

@Entity
@Table(name = "usuario_admin")
public class UsuarioAdmin {
    @Id
    @Column(name = "id_usuario_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_admin_usuario_admin", nullable = false)
    private String nomeAdmin;
    @Column(name = "role_usuario_admin", nullable = false)
    private String role;

    public UsuarioAdmin() {
    }

    public UsuarioAdmin(Long id, String nomeAdmin, String role) {
        this.id = id;
        this.nomeAdmin = nomeAdmin;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
