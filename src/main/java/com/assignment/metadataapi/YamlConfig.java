package com.assignment.metadataapi;


import com.assignment.metadataapi.config.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@ComponentScan("com.assignment.metadataapi")
public class YamlConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters (List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter<>());
    }
}
