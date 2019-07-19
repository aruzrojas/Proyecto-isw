package hello.service;

import hello.repository.RolRepository;
import hello.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import hello.entity.Usuario;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private RolRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Usuario user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public Usuario findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
