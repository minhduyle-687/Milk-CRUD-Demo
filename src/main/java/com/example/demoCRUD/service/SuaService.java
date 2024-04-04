package com.example.demoCRUD.service;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;

import java.util.List;
import java.util.Optional;

public interface SuaService {
    List<Sua> getAllSua();

    Optional<Sua> findSuaByMaSua(String maSua);

    List<Sua> searchSuaByTenSua(String tenSua);

    List<Sua> searchSuaByMaHangSua(String maHangSua);

    List<Sua> searchSuaByMaLoaiSua(String maLoaiSua);

    void createSua(SuaDto sua);

    void updateSua(SuaDto sua);

    void deleteSua(String maSua);
}
