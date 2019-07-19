package hello.service;

import hello.entity.Usuario;

public interface UserService {
    void save(Usuario user);

    Usuario findByUsername(String username);
}
