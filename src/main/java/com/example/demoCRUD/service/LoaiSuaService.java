package com.example.demoCRUD.service;

import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.entity.LoaiSua;

import java.util.List;
import java.util.Optional;

public interface LoaiSuaService {
    List<LoaiSua> getAllLoaiSua();

    LoaiSua findLoaiSuaByMaLoaiSua(String maLoaiSua);

    List<LoaiSua> searchLoaiSuaByTenLoaiSua(String tenLoaiSua);

    void createLoaiSua(LoaiSua loaiSua);

    void updateLoaiSua(LoaiSua loaiSua,String maLoaiSua);

    void deleteLoaiSua(String maLoaiSua);
}
