package com.example.kakeibo_tool;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakeiboResponse {
    private Long kakeiboId;
    private String title;
    private Integer price;
    private Date targetDate;
    private String note;

}
