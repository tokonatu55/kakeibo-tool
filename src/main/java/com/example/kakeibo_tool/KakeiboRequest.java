package com.example.kakeibo_tool;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakeiboRequest {
    private Integer kakeibo_id;
    private String title;
    private String price;
    private LocalDate target_date;
    private String note;
}
