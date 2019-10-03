/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api_project.services;

import com.mycompany.api_project.repositories.Account;
import com.mycompany.api_project.repositories.AccountRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Käyttäjä
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AccountRepository accountrepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
        Account account = accountrepository.findByUsername(username);
        System.out.println(account);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        
        return new org.springframework.security.core.userdetails.User(
        account.getUsername(),
        account.getPassword(),
        true,
        true,
        true,
        true,
        Arrays.asList(new SimpleGrantedAuthority("USER")));
        
    }
    
}
