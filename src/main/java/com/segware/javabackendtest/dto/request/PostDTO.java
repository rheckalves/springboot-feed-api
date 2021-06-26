package com.segware.javabackendtest.dto.request;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    private String content;

    private Integer upvotes = 0;

}
