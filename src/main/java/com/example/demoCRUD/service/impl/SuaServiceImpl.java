package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
import com.example.demoCRUD.repository.SuaRepository;
import com.example.demoCRUD.service.SuaService;
import org.modelmapper.ModelMapper;
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
    public Optional<Sua> findMilkByMilkId(String milkId) {
        return Optional.ofNullable(suaRepository.findMilkByMilkId(milkId));
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
        suaRepository.createMilk(milk);
    }

    @Override
    public void updateMilk(SuaDto milk) {
        suaRepository.updateMilk(milk);
    }

    @Override
    public void deleteMilk(String milkId) {
        Optional<Sua> optionalSua = this.findMilkByMilkId(milkId);
        optionalSua.ifPresent(milk -> suaRepository.deleteMilk(milk));
    }
}
