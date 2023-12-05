package com.virtualvision.erp.config;


import java.util.Locale;// detecta el idioma del navegador

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// i18n abreviatura de internationalization
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
public class LanguagesConfig implements WebMvcConfigurer{
    

    /**establece el idioma por defecto */
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    /**elegimos el otro idioma */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");// este por defecto pilla el del metodo anterior q es "default"
        return lci;
    }
    /**
     * intercepta la peticion (localeChangeInterceptor) y cambia el idioma
     */
    @Override
    public void addInterceptors(InterceptorRegistry intercep){
        intercep.addInterceptor(localeChangeInterceptor());
    }
}
