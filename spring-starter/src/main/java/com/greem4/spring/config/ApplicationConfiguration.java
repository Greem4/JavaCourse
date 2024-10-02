package com.greem4.spring.config;

import com.greem4.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.greem4.spring",
useDefaultFilters = false,
includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = Component.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository"),
})
public class ApplicationConfiguration {

}
