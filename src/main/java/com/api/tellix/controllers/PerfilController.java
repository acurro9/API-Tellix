package com.api.tellix.controllers;

import com.api.tellix.entities.Perfil;
import com.api.tellix.services.PerfilServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/perfiles")
public class PerfilController extends BaseControllerImpl<Perfil, PerfilServiceImpl>{
    
}
