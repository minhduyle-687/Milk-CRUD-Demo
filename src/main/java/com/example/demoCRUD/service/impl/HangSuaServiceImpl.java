package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.repository.HangSuaRepository;
import com.example.demoCRUD.service.HangSuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HangSuaServiceImpl implements HangSuaService {
    @Autowired
    private HangSuaRepository hangSuaRepository;

    @Override
    public List<HangSua> getAllHangSua() {
        return hangSuaRepository.getAllHangSua();
    }

    @Override
    public Optional<HangSua> findHangSuaByMaHangSua(String maHangSua) {
        HangSua hangSua = hangSuaRepository.findHangSuaByMaHangSua(maHangSua);
        return Optional.ofNullable(hangSua);
    }

    @Override
    public List<HangSua> searchHangSuaByTenHangSua(String tenHangSua) {
        return hangSuaRepository.searchHangSuaByTenHangSua(tenHangSua);
    }

    @Override
    public void createHangSua(HangSua hangSua) {
        hangSuaRepository.createHangSua(hangSua);
    }

    @Override
    public void updateHangSua(HangSua hangSua) {
        hangSuaRepository.updateHangSua(hangSua);
    }

    @Override
    public void deleteHangSua(String maHangSua) {
        Optional<HangSua> optionalHangSua = this.findHangSuaByMaHangSua(maHangSua);
        optionalHangSua.ifPresent(hangSua -> hangSuaRepository.deleteHangSua(hangSua));
    }
}
