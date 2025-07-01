package com.example.kakeibo_tool;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KakeiboController {

    private final KakeiboService kakeiboService;

    public KakeiboController(KakeiboService kakeiboService) {
        this.kakeiboService = kakeiboService;
    }

    //登録処理
    @PostMapping("/api/v1/kakeibo")
    public ProcessResultResponse addKakeibo(@RequestBody KakeiboRequest kakeiboRequest) {
        kakeiboService.addKakeibo(kakeiboRequest);
        return new ProcessResultResponse(true, "登録しました。");
    }

    //更新処理
    @PutMapping("/api/v1/kakeibo")
    public ProcessResultResponse updateKakeibo(@RequestBody KakeiboRequest kakeiboRequest) {
        kakeiboService.updateKakeibo(kakeiboRequest);
        return new ProcessResultResponse(true, "更新しました。");
    }

    //削除処理


    //情報一覧取得処理


    //指定情報取得処理
    @GetMapping("/api/v1/kakeibo/{kakeibo_id}")
    public KakeiboResponse fetchKakeibo(@PathVariable("kakeibo_id") Integer kakeibo_id) {
        KakeiboResponse kakeibo = kakeiboService.fetchKakeibo(kakeibo_id);
        return kakeibo;
}
    
}