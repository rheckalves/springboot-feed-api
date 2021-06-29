package com.segware.javabackendtest.dto.request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.segware.javabackendtest.entity.User;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @JsonIgnore
    private Long id;

    @NotNull
    @NotBlank
    private String content;

    @JsonIgnore
    @NotNull
    private User user;

    @JsonIgnore
    private List<Long> upvotesUserIds;

}
