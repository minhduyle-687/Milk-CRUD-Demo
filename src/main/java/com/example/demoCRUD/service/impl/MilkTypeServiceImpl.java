package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.MilkType;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.repository.MilkTypeRepository;
import com.example.demoCRUD.service.MilkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilkTypeServiceImpl implements MilkTypeService {
    @Autowired
    private MilkTypeRepository milkTypeRepository;

    @Override
    public List<MilkType> getAllMilkType() {
        return milkTypeRepository.getAllMilkType();
    }

    @Override
    public MilkType findMilkTypeByMilkTypeId(String maLoaiSua) {
        Optional<MilkType> loaiSuaOptional =
                Optional.ofNullable(milkTypeRepository.findMilkTypeByMilkTypeId(maLoaiSua));
        return loaiSuaOptional.orElseThrow(() -> new CustomException(CustomErrorCode.E203));
    }

    @Override
    public List<MilkType> searchMilkTypeByMilkTypeName(String tenLoaiSua) {
        return milkTypeRepository.searchMilkTypeByMilkTypeName(tenLoaiSua);
    }

    @Override
    public void createMilkType(MilkType milkType) {
        Optional<MilkType> loaiSuaOptional =
                Optional.ofNullable(milkTypeRepository.findMilkTypeByMilkTypeId(milkType.getMilkTypeId()));
        if (loaiSuaOptional.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        milkTypeRepository.createMilkType(milkType);
    }

    @Override
    public void updateMilkType(MilkType milkType, String maLoaiSua) {
        Optional<MilkType> loaiSuaOptional =
                Optional.ofNullable(milkTypeRepository.findMilkTypeByMilkTypeId(maLoaiSua));
        if (loaiSuaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        milkTypeRepository.updateMilkType(milkType);
    }

    @Override
    public void deleteMilkType(String maLoaiSua) {
        Optional<MilkType> loaiSuaOptional = Optional.ofNullable(this.findMilkTypeByMilkTypeId(maLoaiSua));
        if (loaiSuaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        milkTypeRepository.deleteMilkType(loaiSuaOptional.get());
    }
}
