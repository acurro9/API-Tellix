package com.api.tellix.controllers;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.tellix.entities.Base;
/**
 * Interfaz BaseController
 * 
 * Esta interfaz define un contrato genérico para controladores CRUD básicos en la API de Tellix. 
 * Los controladores que extiendan de esta interfaz deberán proveer operaciones estandarizadas sobre una entidad específica.
 * 
 * @param <E>  Representa el tipo de entidad que será gestionada por el controlador. Esta entidad debe heredar de la clase Base.
 * @param <ID> Representa el tipo de dato utilizado como identificador de la entidad (generalmente Long o Integer).
 */
public interface BaseController<E extends Base, ID extends Serializable> {

    /**
     * Recupera todos las entidades desde el repositorio de datos.
     */
    public ResponseEntity<?> getAll();

    /**
     * Recupera todos las entidades (o una página de entidades) desde el repositorio de datos.
     * 
     * @param pageable Objeto Pageable opcional para configurar paginación (tamaño de página, número de página, criterio de ordenación).
     */
    public ResponseEntity<?> getAll(Pageable pageable);

    /**
     * Recupera una entidad específica desde el repositorio de datos usando el ID provisto.
     * 
     * @param id El identificador de la entidad a recuperar.
     */
    public ResponseEntity<?> getOne(@PathVariable ID id);

     /**
     * Persiste una nueva entidad en el repositorio de datos.
     * 
     * @param entity La entidad que será almacenada.
     */
    public ResponseEntity<?> save(@RequestBody E entity);

    /**
     * Actualiza una entidad existente en el repositorio de datos.
     * 
     * @param id     El identificador de la entidad a actualizar.
     * @param entity El objeto entidad con la nueva información a modificar.
     */
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    /**
     * Elimina una entidad del repositorio de datos.
     * 
     * @param id El identificador de la entidad a eliminar.
     */
    public ResponseEntity<?> delete(@PathVariable ID id);
}