package com.example.demoCRUD.service;

import com.example.demoCRUD.dto.MilkDto;
import com.example.demoCRUD.entity.Milk;

import java.util.List;

public interface MilkService {
    List<Milk> getAllMilk();

    Milk findMilkByMilkId(String milkId);

    List<Milk> searchMilkByMilkName(String milkName);

    List<Milk> searchMilkByMilkBranchId(String milkBranchId);

    List<Milk> searchMilkByMilkTypeId(String milkTypeId);

    void createMilk(MilkDto milkDto);

    void updateMilk(MilkDto milkDto, String milkId);

    void deleteMilk(String milkId);
}
