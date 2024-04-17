package com.api.tellix.controllers;

import com.api.tellix.entities.Serie;
import com.api.tellix.services.SerieServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/series")
public class SerieController extends BaseControllerImpl<Serie, SerieServiceImpl>{
    
}
