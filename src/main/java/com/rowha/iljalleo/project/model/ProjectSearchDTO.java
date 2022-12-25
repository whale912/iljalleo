package com.rowha.iljalleo.project.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectSearchDTO {

    @Column
    private String srchPrjtName;

    @Column
    private String srchStrtDate;

    @Column
    private String srchEndDate;

    @Column
    private String srchPrjtSttsCode;

    @Column
    private String srchPrjtTypeCode;

    @Column
    private String srchMngrId;

    @Column
    private String srchRmks;
}
