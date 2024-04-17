package com.api.tellix.controllers;

import com.api.tellix.entities.Capitulo;
import com.api.tellix.services.CapituloServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/capitulos")
public class CapituloController extends BaseControllerImpl<Capitulo, CapituloServiceImpl>{
    
}
