package com.segware.javabackendtest.config;
import com.segware.javabackendtest.mapper.*;
import com.segware.javabackendtest.repository.PostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    public MapperConfig(PostRepository postRepository, FakeSecurityContextConfig fakeLogin) {
        this.postRepository = postRepository;
        this.fakeLogin = fakeLogin;
    }
    private final PostRepository postRepository;
    private final FakeSecurityContextConfig fakeLogin;

    @Bean
    public PostMapper postMapper() {
        return new PostMapperImpl(postRepository, fakeLogin);
    }

    @Bean
    public UserMapper userMapper() { return new UserMapperImpl(); }

}
