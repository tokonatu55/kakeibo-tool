package com.example.kakeibo_tool;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakeiboResponseList {
    private List<KakeiboResponse> kakeiboResponses;
}