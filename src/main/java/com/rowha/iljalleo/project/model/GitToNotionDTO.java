package com.rowha.iljalleo.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitToNotionDTO {
    // git->Notion Json데이터
    String jsonBody;

    // git Commit 목록 가져올 때 사용자정보
    String userId;
    String projectName;
    String token;
}
