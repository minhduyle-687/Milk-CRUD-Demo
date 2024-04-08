package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.repository.SuaRepository;
import com.example.demoCRUD.service.SuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuaServiceImpl implements SuaService {
    @Autowired
    private SuaRepository suaRepository;

    @Override
    public List<Sua> getAllMilk() {
        return suaRepository.getAllMilk();
    }

    @Override
    public Sua findMilkByMilkId(String milkId) {
        Optional<Sua> suaOptional = Optional.ofNullable(suaRepository.findMilkByMilkId(milkId));
        return suaOptional.orElseThrow(() -> new CustomException(CustomErrorCode.E203));
    }

    @Override
    public List<Sua> searchMilkByMilkName(String milkName) {
        return suaRepository.searchMilkByMilkName(milkName);
    }

    @Override
    public List<Sua> searchMilkByMilkBranchId(String milkBranchId) {
        return suaRepository.searchMilkByMilkBranchId(milkBranchId);
    }

    @Override
    public List<Sua> searchMilkByMilkTypeId(String milkTypeId) {
        return suaRepository.searchMilkByMilkTypeId(milkTypeId);
    }

    @Override
    public void createMilk(SuaDto milk) {
        Optional<Sua> suaOptional =
                Optional.ofNullable(suaRepository.findMilkByMilkId(milk.getMaSua()));
        if (suaOptional.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        suaRepository.createMilk(milk);
    }

    @Override
    public void updateMilk(SuaDto milk, String maSua) {
        Optional<Sua> suaOptional =
                Optional.ofNullable(suaRepository.findMilkByMilkId(maSua));
        if (suaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        suaRepository.updateMilk(milk);
    }

    @Override
    public void deleteMilk(String milkId) {
        Optional<Sua> suaOptional = Optional.ofNullable(this.findMilkByMilkId(milkId));
        if (suaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        suaRepository.deleteMilk(suaOptional.get());
    }
}
