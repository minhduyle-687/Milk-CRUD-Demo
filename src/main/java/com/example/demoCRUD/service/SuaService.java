package com.example.demoCRUD.service;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;

import java.util.List;
import java.util.Optional;

public interface SuaService {
    List<Sua> getAllMilk();

    Sua findMilkByMilkId(String maSua);

    List<Sua> searchMilkByMilkName(String tenSua);

    List<Sua> searchMilkByMilkBranchId(String maHangSua);

    List<Sua> searchMilkByMilkTypeId(String maLoaiSua);

    void createMilk(SuaDto sua);

    void updateMilk(SuaDto sua, String maSua);

    void deleteMilk(String maSua);
}
