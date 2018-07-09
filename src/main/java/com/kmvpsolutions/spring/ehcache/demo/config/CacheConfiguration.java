package com.kmvpsolutions.spring.ehcache.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableCaching
@EnableJpaRepositories(basePackages = "com.kmvpsolutions.spring.ehcache.demo.repository")
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(this.cacheManagerFactory().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory(){
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }
}
