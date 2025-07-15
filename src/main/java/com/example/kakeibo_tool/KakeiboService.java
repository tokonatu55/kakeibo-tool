package com.example.kakeibo_tool;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class KakeiboService {

    private final KakeiboRepository kakeiboRepository;

    public KakeiboService(KakeiboRepository kakeiboRepository) {
        this.kakeiboRepository = kakeiboRepository;
    }

    //登録
    @Transactional
    public void addKakeibo(KakeiboRequest kakeiboRequest) {
        //Kakeibo kakeibo = new Kakeibo(kakeiboRequest.getKakeibo_id(), kakeiboRequest.getTitle(), kakeiboRequest.getPrice(), kakeiboRequest.getTarget_date(), kakeiboRequest.getNote());
        Kakeibo kakeibo = new Kakeibo();
        kakeibo.setTitle(kakeiboRequest.getTitle());
        kakeibo.setPrice(kakeiboRequest.getPrice());
        kakeibo.setTargetDate(kakeiboRequest.getTarget_date());
        kakeibo.setNote(kakeiboRequest.getNote());
        kakeiboRepository.save(kakeibo);
    }

    //更新
    @Transactional
    public void updateKakeibo(KakeiboRequest kakeiboRequest) {
        //Kakeibo kakeibo = new Kakeibo(kakeiboRequest.getKakeibo_id(), kakeiboRequest.getTitle(), kakeiboRequest.getPrice(), kakeiboRequest.getTarget_date(), kakeiboRequest.getNote());
        Kakeibo kakeibo = new Kakeibo();
        kakeibo.setTitle(kakeiboRequest.getTitle());
        kakeibo.setPrice(kakeiboRequest.getPrice());
        kakeibo.setTargetDate(kakeiboRequest.getTarget_date());
        kakeibo.setNote(kakeiboRequest.getNote());
        kakeiboRepository.save(kakeibo);
    }

    //削除
    @Transactional
    public void deleteKakeibo(Long kakeibo_id) {
        kakeiboRepository.deleteById(kakeibo_id);
        return;
    }

    //情報一覧取得処理
    /*public KakeiboResponseList fetchAllKakeibo() {
        List<Kakeibo> records = kakeiboRepository.findAll();

        List<KakeiboResponse> kakeiboResponses = records.stream()
            .map(kakeibo -> new KakeiboResponse(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTargetDate(), kakeibo.getNote()))
            .toList();
        KakeiboResponseList kakeiboResponseList = new KakeiboResponseList(kakeiboResponses);
        return kakeiboResponseList;
    }*/

    public KakeiboResponseList fetchKakeibo(Date targetDate) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);

        // 月初（例: 2025-07-01 00:00:00）
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startDate = cal.getTime();

        // 翌月初（例: 2025-08-01 00:00:00）→ 「未満」で月末までカバー
        cal.add(Calendar.MONTH, 1);
        Date endDate = cal.getTime();

        //List<Kakeibo> records = kakeiboRepository.findAllByTargetDate(targetDate);
        List<Kakeibo> records = kakeiboRepository.findAllByTargetDateBetween(startDate, endDate);
        List<KakeiboResponse> kakeiboResponses = records.stream()
            .map(kakeibo -> new KakeiboResponse(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTargetDate(), kakeibo.getNote()))
            .toList();
        KakeiboResponseList kakeiboResponseList = new KakeiboResponseList(kakeiboResponses);
        return kakeiboResponseList;
    }


    //指定情報取得処理
    public KakeiboResponse fetchKakeibo(Long kakeibo_id) {
        Optional<Kakeibo> record = kakeiboRepository.findById(kakeibo_id);
        if (record.isEmpty()) {
            throw new NoSuchElementException("指定したレコードがありません。");
        }
        Kakeibo kakeibo = record.get();
        KakeiboResponse kakeiboResponse = new KakeiboResponse(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTargetDate(), kakeibo.getNote());
        return kakeiboResponse;
    }
}