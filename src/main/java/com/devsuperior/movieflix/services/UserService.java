package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTO.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public UserDTO getUserAuthenticated(){
       User user = authService.authenticated();
       return new UserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByEmail(s);
        if(user == null){
            logger.error("Usuário não encontrado migão = " + s);
            throw new UsernameNotFoundException("Email não encontrado");
        }
        logger.info("Usuário encontrado = " + s);
        return user;
    }
}
