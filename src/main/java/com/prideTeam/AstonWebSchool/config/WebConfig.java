package com.prideTeam.AstonWebSchool.config;

import com.prideTeam.AstonWebSchool.jackson.JsonObjectMapper;
import com.prideTeam.AstonWebSchool.jackson.XmlObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(JsonObjectMapper.getMapper()));
        converters.add(new MappingJackson2XmlHttpMessageConverter(XmlObjectMapper.getMapper()));
    }
}
