package com.example.kakeibo_tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessResultResponse {
    private Boolean result;
    private String message;
}
