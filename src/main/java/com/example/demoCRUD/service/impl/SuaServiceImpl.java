package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
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
    public List<Sua> getAllSua() {
        return suaRepository.getAllSua();
    }

    @Override
    public Optional<Sua> findSuaByMaSua(String maSua) {
        return Optional.ofNullable(suaRepository.findSuaByMaSua(maSua));
    }

    @Override
    public List<Sua> searchSuaByTenSua(String tenSua) {
        return suaRepository.searchSuaByTenSua(tenSua);
    }

    @Override
    public List<Sua> searchSuaByMaHangSua(String maHangSua) {
        return suaRepository.searchSuaByMaHangSua(maHangSua);
    }

    @Override
    public List<Sua> searchSuaByMaLoaiSua(String maLoaiSua) {
        return suaRepository.searchSuaByMaLoaiSua(maLoaiSua);
    }

    @Override
    public void createSua(SuaDto sua) {
        suaRepository.createSua(sua);
    }

    @Override
    public void updateSua(SuaDto sua) {
        suaRepository.updateSua(sua);
    }

    @Override
    public void deleteSua(String maSua) {
        Optional<Sua> optionalSua = this.findSuaByMaSua(maSua);
        optionalSua.ifPresent(sua->suaRepository.deleteSua(sua));
    }
}
