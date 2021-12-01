package com.assignment.metadataapi.config;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;


public class YamlJackson2HttpMessageConverter<T> extends AbstractJackson2HttpMessageConverter {
    public YamlJackson2HttpMessageConverter () {
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }

}
