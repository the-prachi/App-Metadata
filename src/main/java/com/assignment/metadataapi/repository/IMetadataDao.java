package com.assignment.metadataapi.repository;

import com.assignment.metadataapi.model.Metadata;

import java.util.Map;

public interface IMetadataDao {

    void addMetadata(Metadata metadata);
    Metadata getMetadata(String title);
    void updateMetadata(Metadata metadata);
    Map<String, Metadata> getAllMetadata();
    void deleteMetadata(String title);

}
