package com.example.demoCRUD.repository;

import com.example.demoCRUD.entity.MilkType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MilkTypeRepository {
    List<MilkType> getAllMilkType();

    MilkType findMilkTypeByMilkTypeId(String milkTypeId);

    List<MilkType> searchMilkTypeByMilkTypeName(String milkTypeName);

    void createMilkType(MilkType milkType);

    void updateMilkType(MilkType milkType);

    void deleteMilkType(MilkType milkType);
}
