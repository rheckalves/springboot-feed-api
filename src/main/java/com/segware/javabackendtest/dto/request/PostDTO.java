package com.segware.javabackendtest.dto.request;
import lombok.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;

    @NotNull
    private String content;

    private Integer upvotes = 0;

    private String username;

    private Long userId;
}
