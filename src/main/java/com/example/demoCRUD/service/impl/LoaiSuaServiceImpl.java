package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.entity.LoaiSua;
import com.example.demoCRUD.repository.LoaiSuaRepository;
import com.example.demoCRUD.service.LoaiSuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSuaServiceImpl implements LoaiSuaService {
    @Autowired
    private LoaiSuaRepository loaiSuaRepository;

    @Override
    public List<LoaiSua> getAllLoaiSua() {
        return loaiSuaRepository.getAllLoaiSua();
    }

    @Override
    public Optional<LoaiSua> findLoaiSuaByMaLoaiSua(String maLoaiSua) {
        LoaiSua loaiSua = loaiSuaRepository.findLoaiSuaByMaLoaiSua(maLoaiSua);
        return Optional.ofNullable(loaiSua);
    }

    @Override
    public List<LoaiSua> searchLoaiSuaByTenLoaiSua(String tenLoaiSua) {
        return loaiSuaRepository.searchLoaiSuaByTenLoaiSua(tenLoaiSua);
    }

    @Override
    public void createLoaiSua(LoaiSua loaiSua) {
        loaiSuaRepository.createLoaiSua(loaiSua);
    }

    @Override
    public void updateLoaiSua(LoaiSua loaiSua) {
        loaiSuaRepository.updateLoaiSua(loaiSua);
    }

    @Override
    public void deleteLoaiSua(String maLoaiSua) {
        Optional<LoaiSua> optionalLoaiSua = this.findLoaiSuaByMaLoaiSua(maLoaiSua);
        optionalLoaiSua.ifPresent(loaiSua -> loaiSuaRepository.deleteLoaiSua(loaiSua));
    }
}
