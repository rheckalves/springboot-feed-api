package com.segware.javabackendtest.config;
import com.segware.javabackendtest.mapper.PostMapper;
import com.segware.javabackendtest.mapper.PostMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PostMapper postMapper() {
        return new PostMapperImpl();
    }
}
