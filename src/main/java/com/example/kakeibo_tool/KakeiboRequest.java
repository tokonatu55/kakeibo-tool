package com.example.kakeibo_tool;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakeiboRequest {
    private Integer kakeibo_id;
    private String title;
    private Integer price;
    private Date target_date;
    private String note;
}
