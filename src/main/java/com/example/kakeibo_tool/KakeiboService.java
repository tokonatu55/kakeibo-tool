package com.example.kakeibo_tool;

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
        Kakeibo kakeibo = new Kakeibo(kakeiboRequest.getKakeibo_id(), kakeiboRequest.getTitle(), kakeiboRequest.getPrice(), kakeiboRequest.getTarget_date(), kakeiboRequest.getNote());
        kakeiboRepository.save(kakeibo);
    }

    //更新
    @Transactional
    public void updateKakeibo(KakeiboRequest kakeiboRequest) {
        Kakeibo kakeibo = new Kakeibo(kakeiboRequest.getKakeibo_id(), kakeiboRequest.getTitle(), kakeiboRequest.getPrice(), kakeiboRequest.getTarget_date(), kakeiboRequest.getNote());
        kakeiboRepository.save(kakeibo);
    }

    //削除


    //情報一覧取得処理


    //指定情報取得処理
    public KakeiboResponse fetchKakeibo(Integer kakeibo_id) {
        Optional<Kakeibo> record = kakeiboRepository.findById(kakeibo_id);
        if (record.isEmpty()) {
            throw new NoSuchElementException("指定したレコードがありません。");
        }
        Kakeibo kakeibo = record.get();
        KakeiboResponse kakeiboResponse = new KakeiboResponse(kakeibo.getKakeibo_id(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTarget_date(), kakeibo.getNote());
        return kakeiboResponse;
    }
}