package com.example.demoCRUD.service;

import com.example.demoCRUD.entity.MilkType;

import java.util.List;

public interface MilkTypeService {
    List<MilkType> getAllMilkType();

    MilkType findMilkTypeByMilkTypeId(String milkTypeId);

    List<MilkType> searchMilkTypeByMilkTypeName(String milkTypeName);

    void createMilkType(MilkType milkType);

    void updateMilkType(MilkType milkType, String milkTypeId);

    void deleteMilkType(String milkTypeId);
}
