package com.example.demoCRUD.repository;

import com.example.demoCRUD.dto.MilkDto;
import com.example.demoCRUD.entity.Milk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MilkRepository {
    List<Milk> getAllMilk();

    Milk findMilkByMilkId(String milkId);

    List<Milk> searchMilkByMilkName(String milkName);

    List<Milk> searchMilkByMilkBranchId(String milkBranchId);

    List<Milk> searchMilkByMilkTypeId(String milkTypeId);

    void createMilk(MilkDto milkDto);

    void updateMilk(MilkDto milkDto);

    void deleteMilk(Milk milk);
}
