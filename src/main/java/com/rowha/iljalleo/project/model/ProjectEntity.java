package com.rowha.iljalleo.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="prjtBasc")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 프로젝트ID
    private int prjtId;

    @Column(length=100, nullable = false)
    // 프로젝트명
    private String prjtName;

    @Column(length=5)
    // 프로젝트 상태 코드
    private String prjtSttsCode;

    @Column(length=5)
    // 프로젝트 유형 코드
    private String prjtTypeCode;

    @Column(length=5)
    // 프로젝트 색상 코드
    private String prjtClrCode;

    @Column
    // 고객사ID
    private int cstmCmpnId;

    @Column(length=50)
    // 관리자ID
    private String mngrId;

    @Column(length=6)
    // 기대시작연월
    private String exptStrtYm;

    @Column
    // 프로젝트 기간(월)
    private int prjtDur;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    // 시작일자
    private LocalDate strtDate;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    // 종료일자
    private LocalDate endDate;

    @Column(length=500)
    // 비고
    private String rmks;

    @Column(length=50)
    // 등록자ID
    private String rgstId;

    @Column
    @CreationTimestamp
    // 등록일시
    private LocalDateTime rgstDttm;

    @Column(length=50)
    // 수정자ID
    private String uptId;

    @Column
    @UpdateTimestamp
    // 수정일시
    private LocalDateTime uptDttm;
}
