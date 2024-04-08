package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.HangSuaDto;
import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.repository.HangSuaRepository;
import com.example.demoCRUD.service.HangSuaService;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
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
    public HangSua findHangSuaByMaHangSua(String maHangSua) {
        HangSua hangSua = hangSuaRepository.findHangSuaByMaHangSua(maHangSua);
        if (!hangSua.getMaHangSua().isEmpty())
            return hangSuaRepository.findHangSuaByMaHangSua(maHangSua);
        throw new CustomException(CustomErrorCode.E203);
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
        HangSua hangSua = this.findHangSuaByMaHangSua(maHangSua);
        if (!hangSua.getMaHangSua().isEmpty())
            hangSuaRepository.deleteHangSua(hangSua);

    }
}
