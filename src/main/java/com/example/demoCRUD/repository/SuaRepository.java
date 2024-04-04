package com.example.demoCRUD.repository;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.entity.Sua;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SuaRepository {
    List<Sua> getAllSua();

    Sua findSuaByMaSua(String maSua);

    List<Sua> searchSuaByTenSua(String tenSua);

    List<Sua> searchSuaByMaHangSua(String maHangSua);

    List<Sua> searchSuaByMaLoaiSua(String maLoaiSua);

    void createSua(SuaDto sua);

    void updateSua(SuaDto sua);

    void deleteSua(Sua sua);
}
