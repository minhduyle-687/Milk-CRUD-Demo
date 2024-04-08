package com.example.demoCRUD.service;


import com.example.demoCRUD.dto.HangSuaDto;
import com.example.demoCRUD.entity.HangSua;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface HangSuaService {
    List<HangSua> getAllHangSua();

    HangSua findHangSuaByMaHangSua(String maHangSua);

    List<HangSua> searchHangSuaByTenHangSua(String tenHangSua);

    void createHangSua(HangSua hangSua);

    void updateHangSua(HangSua hangSua,String maHangSua);

    void deleteHangSua(String tenHangSua);
}
