package com.assignment.metadataapi.repository;

import com.assignment.metadataapi.model.Metadata;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class MetadataDaoImpl implements IMetadataDao{

    private final String hashMetaData = "Metadata";


    @Resource(name="redisTemplate")
    private HashOperations<String, String, Metadata> hashOperations;

    @Override
    public void addMetadata(Metadata metadata){
        hashOperations.putIfAbsent(hashMetaData, metadata.getTitle(), metadata);
    }
    @Override
    public Metadata getMetadata(String title){
        return hashOperations.get(hashMetaData, title);
    }
    @Override
    public void updateMetadata(Metadata metadata) {
        hashOperations.put(hashMetaData, metadata.getTitle(), metadata);
    }

    @Override
    public Map<String, Metadata> getAllMetadata() {
        return hashOperations.entries(hashMetaData);
    }

    @Override
    public void deleteMetadata(String title) {
        hashOperations.delete(hashMetaData, title);
    }

}
