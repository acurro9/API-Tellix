package com.api.tellix.controllers;

import com.api.tellix.entities.Categoria;
import com.api.tellix.services.CategoriaServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{
    
}
