/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api_project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Käyttäjä
 */
public interface AccountRepository extends MongoRepository<Account, String> {
    
    Account findByUsername(String username);
    
}
