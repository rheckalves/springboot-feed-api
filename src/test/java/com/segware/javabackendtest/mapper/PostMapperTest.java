package com.segware.javabackendtest.mapper;

import com.segware.javabackendtest.config.MapperConfig;
import com.segware.javabackendtest.dto.request.PostDTO;
import com.segware.javabackendtest.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.segware.javabackendtest.utils.PostUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostMapperTest {


    @InjectMocks
    private MapperConfig mapper;


    @Test
    void shoudConvertEntityToDTO() {
        PostDTO postDTO = createFakeDTO();
        Post post = createFakeEntity();

        PostDTO coververtedToDTO = mapper.postMapper().toDTO(post);

        assertEquals(coververtedToDTO, postDTO);
    }

    @Test
    void shoudConvertDTOToEntity() {
        PostDTO postDTO = createFakeDTO();
        Post post = createFakeEntity();

        Post coververtedToEntity = mapper.postMapper().toModel(postDTO);

        assertEquals(coververtedToEntity, post);
    }
}
