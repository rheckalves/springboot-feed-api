package com.segware.javabackendtest.dto.request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @JsonIgnore
    private Long id;

    @NotNull
    private String content;

    @JsonIgnore
    private Integer upvotes = 0;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private Long userId;
}
