package com.example.kakeibo_tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@CrossOrigin
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
    @DeleteMapping("/api/v1/kakeibo/{kakeibo_id}")
    public ProcessResultResponse deleteKakeibo(@PathVariable("kakeibo_id") Long kakeiboId) {
        kakeiboService.deleteKakeibo(kakeiboId);
        return new ProcessResultResponse(true, "削除しました。");
    }

    //情報一覧取得処理
    @GetMapping("/api/v1/kakeiboes/{targetmonth}")
    public KakeiboResponseList fetchKakeibo(@PathVariable("targetmonth") String targetMonth) throws ParseException {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMM");
        Date targetDate = sdFormat.parse(targetMonth); //例：2025-08-01 00:00:00
        KakeiboResponseList list = kakeiboService.fetchKakeibo(targetDate);
        //System.out.println("一覧取得が実行されました。対象月：" + targetMonth);
        //log.info("一覧取得が実行されました。対象月：{}", targetMonth);
        return list;
    }

    //指定情報取得処理
    @GetMapping("/api/v1/kakeibo/{kakeibo_id}")
    public KakeiboResponse fetchKakeibo(@PathVariable("kakeibo_id") Long kakeiboId) {
        KakeiboResponse kakeibo = kakeiboService.fetchKakeibo(kakeiboId);
        return kakeibo;
    }
}