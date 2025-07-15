package com.example.kakeibo_tool;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface KakeiboRepository extends JpaRepository<Kakeibo, Long> {
    //List<Kakeibo> findAllByDeleteFlg(boolean deleteFlg);
    //List<Kakeibo> findAllByTargetDate(Date targetDate);
    List<Kakeibo> findAllByTargetDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}