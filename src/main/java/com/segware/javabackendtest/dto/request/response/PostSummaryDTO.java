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

    private Long id;

    private String content;

    private Integer upvotes = 0;

    private String username;

    private Boolean upvotedByUser = false;

    private Long userId;
}