package com.segware.javabackendtest.dto.request.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostSummaryDTO {
    @NotNull
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private Integer upvotes = 0;

    @NotNull
    private String username;

    private Boolean upvotedByUser = false;

    @NotNull
    private Long userId;
}