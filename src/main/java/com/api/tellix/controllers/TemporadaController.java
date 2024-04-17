package com.api.tellix.controllers;

import com.api.tellix.entities.Temporada;
import com.api.tellix.services.TemporadaServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/temporadas")
public class TemporadaController extends BaseControllerImpl<Temporada, TemporadaServiceImpl>{
    
}
