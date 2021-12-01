package com.assignment.metadataapi.controllers;

/*
Class: MetadataController
Description: Controller class that takes input from the user and
calls the respective endpoints to process the request and return the response.
Author:Prachi Gupta
 */

import com.assignment.metadataapi.model.Maintainers;
import com.assignment.metadataapi.model.Metadata;

import com.assignment.metadataapi.repository.IMetadataDao;
import com.assignment.metadataapi.utility.EmailAddressValidator;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/v1")
@Validated
public class MetadataController {
    /*
    Method Name: getAllResources
    Params: NA
    Description: Returns all the resources in Foo
     */

    @Autowired
    IMetadataDao metadataDao;

    @PostMapping(
            value = "/metadata",
            consumes = "application/x-yaml"
    )
    @ResponseBody
    public ResponseEntity<String> addMetadata(@Valid @RequestBody Metadata metadata) {

        List<Maintainers> maintainersList = metadata.getMaintainers();
        boolean flag = false;
        for (Maintainers maintainer : maintainersList) {
            flag = EmailAddressValidator.validateEmailAddress(maintainer.getEmail());
            if (!flag) {
                return new ResponseEntity<String>("Email is not valid", HttpStatus.BAD_REQUEST);
            }
        }
        try {
            metadataDao.addMetadata(metadata);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/metadata")
    public ResponseEntity<Map<String, Metadata>> getAllMetadata() {
        Map<String, Metadata> output;
        try{
            output = metadataDao.getAllMetadata();
            return new ResponseEntity<Map<String, Metadata>>(output, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map<String, Metadata>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/metadata/{title}")
    public ResponseEntity<Metadata> getMetadata(@PathVariable("title") final String title) {
        try{
            Metadata output = metadataDao.getMetadata(title);
            return new ResponseEntity<Metadata>(output, HttpStatus.OK);
        }
        catch(ResourceNotFoundException e){
            return new ResponseEntity<Metadata>(HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/metadata/{title}")
    public ResponseEntity<Void> deleteMetadata(@PathVariable("title") final String title) {
        try{
            metadataDao.deleteMetadata(title);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }
        catch(ResourceNotFoundException e){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/metadata",consumes = "application/x-yaml")
    public ResponseEntity<String> updateResource(@RequestBody Metadata metadata){
        List<Maintainers> maintainersList = metadata.getMaintainers();
        boolean flag = false;
        for (Maintainers maintainer : maintainersList) {
            flag = EmailAddressValidator.validateEmailAddress(maintainer.getEmail());
            if (!flag) {
                return new ResponseEntity<String>("Email is not valid", HttpStatus.BAD_REQUEST);
            }
        }
        try{
            metadataDao.updateMetadata(metadata);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}




