package com.disney.auth.service;

import java.util.Collections;

import com.disney.auth.dto.UserDTO;
import com.disney.auth.entity.UserEntity;
import com.disney.auth.repository.UserRepository;
import com.disney.exception.ErrorsEnum;
import com.disney.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(ErrorsEnum.USERNOTFOUND.getMessage());
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO dto) throws Exception {
        
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity = userRepository.save(userEntity);
        if (userEntity != null) {
           emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }
    
}
