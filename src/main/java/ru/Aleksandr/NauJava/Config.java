package ru.Aleksandr.NauJava;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config<User> {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Object> userContainer() {
        return new ArrayList<>().reversed();
    }
}
