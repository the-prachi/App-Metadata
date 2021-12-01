package com.assignment.metadataapi.config;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

/*
Class: YamlJackson2HttpMessageConverter
Description: Config class to configure yaml as valid media type
Author:Prachi Gupta
 */

public class YamlJackson2HttpMessageConverter<T> extends AbstractJackson2HttpMessageConverter {
    public YamlJackson2HttpMessageConverter () {
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }

}
