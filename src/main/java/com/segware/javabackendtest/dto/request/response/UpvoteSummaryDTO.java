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
public class UpvoteSummaryDTO {

    @NotNull
    private Long postId;

    @NotNull
    private Boolean upvoted;
}
