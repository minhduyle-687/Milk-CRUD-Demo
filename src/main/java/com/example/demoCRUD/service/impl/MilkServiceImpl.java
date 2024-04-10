package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.MilkDto;
import com.example.demoCRUD.entity.Milk;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.repository.MilkRepository;
import com.example.demoCRUD.service.MilkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilkServiceImpl implements MilkService {
    @Autowired
    private MilkRepository milkRepository;

    @Override
    public List<Milk> getAllMilk() {
        return milkRepository.getAllMilk();
    }

    @Override
    public Milk findMilkByMilkId(String milkId) {
        Optional<Milk> suaOptional = Optional.ofNullable(milkRepository.findMilkByMilkId(milkId));
        return suaOptional.orElseThrow(() -> new CustomException(CustomErrorCode.E203));
    }

    @Override
    public List<Milk> searchMilkByMilkName(String milkName) {
        return milkRepository.searchMilkByMilkName(milkName);
    }

    @Override
    public List<Milk> searchMilkByMilkBranchId(String milkBranchId) {
        return milkRepository.searchMilkByMilkBranchId(milkBranchId);
    }

    @Override
    public List<Milk> searchMilkByMilkTypeId(String milkTypeId) {
        return milkRepository.searchMilkByMilkTypeId(milkTypeId);
    }

    @Override
    public void createMilk(MilkDto milk) {
        Optional<Milk> suaOptional =
                Optional.ofNullable(milkRepository.findMilkByMilkId(milk.getMaSua()));
        if (suaOptional.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        milkRepository.createMilk(milk);
    }

    @Override
    public void updateMilk(MilkDto milk, String maSua) {
        Optional<Milk> suaOptional =
                Optional.ofNullable(milkRepository.findMilkByMilkId(maSua));
        if (suaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        milkRepository.updateMilk(milk);
    }

    @Override
    public void deleteMilk(String milkId) {
        Optional<Milk> suaOptional = Optional.ofNullable(this.findMilkByMilkId(milkId));
        if (suaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        milkRepository.deleteMilk(suaOptional.get());
    }
}
