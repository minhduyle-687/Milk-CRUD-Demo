package com.example.demoCRUD.repository;

import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.entity.LoaiSua;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LoaiSuaRepository {
    List<LoaiSua> getAllLoaiSua();

    LoaiSua findLoaiSuaByMaLoaiSua(String maLoaiSua);

    List<LoaiSua> searchLoaiSuaByTenLoaiSua(String tenLoaiSua);

    void createLoaiSua(LoaiSua loaiSua);

    void updateLoaiSua(LoaiSua loaiSua);

    void deleteLoaiSua(LoaiSua loaiSua);
}
