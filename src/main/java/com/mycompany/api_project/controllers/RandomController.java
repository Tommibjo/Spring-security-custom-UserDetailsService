/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Käyttäjä
 */
@RestController
public class RandomController {
 
    @GetMapping("/api/hello")
    public String additives(){
        return "Hello world";
    }
    
}
