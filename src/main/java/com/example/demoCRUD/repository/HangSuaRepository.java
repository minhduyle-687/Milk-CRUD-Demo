package com.example.demoCRUD.repository;

import com.example.demoCRUD.entity.HangSua;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface HangSuaRepository {
    List<HangSua> getAllHangSua();

    HangSua findHangSuaByMaHangSua(String maHangSua);

    List<HangSua> searchHangSuaByTenHangSua(String tenHangSua);

    void createHangSua(HangSua hangSua);

    void updateHangSua(HangSua hangSua);

    void deleteHangSua(HangSua hangSua);
}
