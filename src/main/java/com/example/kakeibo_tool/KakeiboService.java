package com.example.kakeibo_tool;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        kakeibo.setTargetDate(kakeiboRequest.getTargetDate());
        kakeibo.setNote(kakeiboRequest.getNote());
        kakeiboRepository.save(kakeibo);
    }

    //更新
    @Transactional
    public void updateKakeibo(KakeiboRequest kakeiboRequest) {
        Optional<Kakeibo> optionalKakeibo = kakeiboRepository.findById(kakeiboRequest.getKakeiboId());
        //Kakeibo kakeibo = new Kakeibo(kakeiboRequest.getKakeibo_id(), kakeiboRequest.getTitle(), kakeiboRequest.getPrice(), kakeiboRequest.getTarget_date(), kakeiboRequest.getNote());
        Kakeibo kakeibo = optionalKakeibo.get();
        if (kakeiboRequest.getTitle() != null) {
        kakeibo.setTitle(kakeiboRequest.getTitle());
        }
        if (kakeiboRequest.getPrice() != null) {
        kakeibo.setPrice(kakeiboRequest.getPrice());
        }
        if (kakeiboRequest.getNote() != null) {
        kakeibo.setNote(kakeiboRequest.getNote());
        }
        kakeiboRepository.save(kakeibo);
    }

    //削除
    @Transactional
    public void deleteKakeibo(Long kakeiboId) {
        kakeiboRepository.deleteById(kakeiboId);
        return;
    }

    //情報一覧取得処理
    public KakeiboResponseList fetchKakeibo(Date targetDate) {

        Date startDate = DateUtility.createStartDateOfMonth(targetDate);
        Date endDate = DateUtility.createEndDateOfMonth(targetDate);

        //List<Kakeibo> records = kakeiboRepository.findAllByTargetDate(targetDate);
        List<Kakeibo> records = kakeiboRepository.findAllByTargetDateBetween(startDate, endDate);
        List<KakeiboResponse> kakeiboResponses = records.stream()
            .map(kakeibo -> new KakeiboResponse(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTargetDate(), kakeibo.getNote()))
            .toList();
        KakeiboResponseList kakeiboResponseList = new KakeiboResponseList(kakeiboResponses);
        return kakeiboResponseList;
    }


    //指定情報取得処理
    public KakeiboResponse fetchKakeibo(Long kakeiboId) {
        Optional<Kakeibo> record = kakeiboRepository.findById(kakeiboId);
        if (record.isEmpty()) {
            log.error("指定したレコードがありません。");
            throw new NoSuchElementException("指定したレコードがありません。");
        }
        Kakeibo kakeibo = record.get();
        KakeiboResponse kakeiboResponse = new KakeiboResponse(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getPrice(), kakeibo.getTargetDate(), kakeibo.getNote());
        return kakeiboResponse;
    }
}