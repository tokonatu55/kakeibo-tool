package com.example.kakeibo_tool;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "家計簿情報テーブル")
public class Kakeibo {

    @Id
    @Column
    private Integer kakeibo_id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String price;

    @Column(nullable = true)
    private LocalDate target_date;

    @Column(nullable = true)
    private String note;
}
