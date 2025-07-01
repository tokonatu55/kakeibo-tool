package com.example.kakeibo_tool;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KakeiboRepository extends JpaRepository<Kakeibo, Integer> {
    //List<Kakeibo> findAllByDeleteFlg(boolean deleteFlg);
}