package com.assignment.metadataapi.repository;

import com.assignment.metadataapi.model.Metadata;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/*
Class: MetadataDaoImpl
Description: Repository class that takes input from the user and
calls the redis to read and write the request and return the response.
Author:Prachi Gupta
 */

@Repository
public class MetadataDaoImpl implements IMetadataDao{

    private final String hashMetaData = "Metadata";


    @Resource(name="redisTemplate")
    private HashOperations<String, String, Metadata> hashOperations;

    /*
        Method: addMetadata
        Params: Metadata
        Description: Adds the metadata resource in redis
     */
    @Override
    public void addMetadata(Metadata metadata){
        hashOperations.putIfAbsent(hashMetaData, metadata.getTitle(), metadata);
    }
     /*
        Method: getMetadata
        Params: String
        Description: Gets the metadata resource from redis
     */
    @Override
    public Metadata getMetadata(String title){
        return hashOperations.get(hashMetaData, title);
    }
    /*
        Method: updateMetadata
        Params: Metadata
        Description: Updates the metadata resource in redis
     */
    @Override
    public void updateMetadata(Metadata metadata) {
        hashOperations.put(hashMetaData, metadata.getTitle(), metadata);
    }
    /*
        Method: getAllMetadata
        Params: NA
        Description: Gets all the metadata resource from redis
     */
    @Override
    public Map<String, Metadata> getAllMetadata() {
        return hashOperations.entries(hashMetaData);
    }

     /*
        Method: deleteMetadata
        Params: String
        Description: Deletes the metadata resource from redis
     */
    @Override
    public void deleteMetadata(String title) {
        hashOperations.delete(hashMetaData, title);
    }

}
