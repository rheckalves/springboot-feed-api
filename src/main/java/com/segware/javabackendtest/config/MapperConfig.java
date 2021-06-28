package com.segware.javabackendtest.config;
import com.segware.javabackendtest.mapper.PostMapper;
import com.segware.javabackendtest.mapper.PostMapperImpl;
import com.segware.javabackendtest.mapper.UserMapper;
import com.segware.javabackendtest.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PostMapper postMapper() {
        return new PostMapperImpl();
    }

    @Bean
    public UserMapper userMapper() { return new UserMapperImpl(); }
}
