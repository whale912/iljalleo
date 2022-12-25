package com.rowha.iljalleo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="prjtBasc")
public class PrjtBasc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prjtId;

    @Column(length=100, nullable = false)
    private String prjtName;
}
