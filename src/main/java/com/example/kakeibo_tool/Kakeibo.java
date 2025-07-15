package com.example.kakeibo_tool;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kakeibo", schema = "prd")
public class Kakeibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kakeibo_id")
    private Long kakeiboId;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private Integer price;

    @Column(name = "target_date", nullable = true)
    private Date targetDate;

    @Column(nullable = true)
    private String note;
}
