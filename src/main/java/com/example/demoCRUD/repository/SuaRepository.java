package com.example.demoCRUD.repository;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuaRepository {
    List<Sua> getAllMilk();

    Sua findMilkByMilkId(String milkId);

    List<Sua> searchMilkByMilkName(String milkName);

    List<Sua> searchMilkByMilkBranchId(String milkBranchId);

    List<Sua> searchMilkByMilkTypeId(String milkTypeId);

    void createMilk(SuaDto milkDto);

    void updateMilk(SuaDto milkDto);

    void deleteMilk(Sua milk);
}
