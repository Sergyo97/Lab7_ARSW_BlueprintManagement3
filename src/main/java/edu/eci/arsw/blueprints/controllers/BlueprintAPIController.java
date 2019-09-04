/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

/**
 *
 * @author hcadavid
 */
@RestController
public class BlueprintAPIController {
    @Autowired
    BlueprintsServices bps;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllBlueprints() {
        try {
            return new ResponseEntity<>(bps.getAllBlueprints(), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("Error, no blueprints were found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/blueprints/{author}")
    public ResponseEntity<?> getAllBluePrintsByAuthor(@PathVariable String author) {
        try {
            return new ResponseEntity<>(bps.getBlueprintsByAuthor(author), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error, the author has not blueprints", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/blueprints/{author}/{name}")
    public ResponseEntity<?> getAllBluePrintsByAuthorAndName(@PathVariable String author, @PathVariable String name) {
        try {
            return new ResponseEntity<>(bps.getBlueprint(author, name), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error, the author has not blueprints", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/blueprints")
    public ResponseEntity<?> manejadorPostRecursoXX(@RequestBody Blueprint bp) {
        
        try {
            bps.addNewBlueprint(bp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }

    }
}