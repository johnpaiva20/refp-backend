package com.tostringtech.refp.application.authentication.core.services;

import com.tostringtech.refp.application.authentication.api.repository.UserRepository;
import com.tostringtech.refp.application.authentication.core.models.CustomUserDetais;
import com.tostringtech.refp.application.authentication.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User findUserByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail);
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));

        return new CustomUserDetais(user, authorities);
    }


}
