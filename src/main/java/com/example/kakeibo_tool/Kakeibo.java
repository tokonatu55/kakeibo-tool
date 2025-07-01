package com.example.kakeibo_tool;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "kakeibo")
public class Kakeibo {

    @Id
    @Column
    private Integer kakeibo_id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private Integer price;

    @Column(nullable = true)
    private Date target_date;

    @Column(nullable = true)
    private String note;
}
