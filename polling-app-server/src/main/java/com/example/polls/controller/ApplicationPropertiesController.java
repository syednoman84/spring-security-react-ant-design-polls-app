package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/props")
public class ApplicationPropertiesController {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;


    @GetMapping
    public String getProperties() {
        Optional<PropertySource<?>> str = configurableEnvironment.getPropertySources()
                .stream()
                .filter(propertySource -> propertySource.getName()
                        .contains("application.properties")).findFirst();

        return str.get().getSource().toString();

//        Map<String, Object> mapOfProperties = configurableEnvironment.getPropertySources()
//                .stream()
//                .filter(propertySource -> propertySource.getName()
//                        .contains("application.properties"))
//                .collect(Collectors.toMap(PropertySource::getName, PropertySource::getSource));
//
//        System.out.println(mapOfProperties.size());

//        return mapOfProperties.values().toString();

    }

}