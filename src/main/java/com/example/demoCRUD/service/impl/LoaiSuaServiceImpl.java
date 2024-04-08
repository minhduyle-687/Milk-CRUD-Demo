package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.LoaiSua;
import com.example.demoCRUD.exception.CustomException;
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
    public LoaiSua findLoaiSuaByMaLoaiSua(String maLoaiSua) {
        Optional<LoaiSua> loaiSuaOptional =
                Optional.ofNullable(loaiSuaRepository.findLoaiSuaByMaLoaiSua(maLoaiSua));
        return loaiSuaOptional.orElseThrow(() -> new CustomException(CustomErrorCode.E203));
    }

    @Override
    public List<LoaiSua> searchLoaiSuaByTenLoaiSua(String tenLoaiSua) {
        return loaiSuaRepository.searchLoaiSuaByTenLoaiSua(tenLoaiSua);
    }

    @Override
    public void createLoaiSua(LoaiSua loaiSua) {
        Optional<LoaiSua> loaiSuaOptional =
                Optional.ofNullable(loaiSuaRepository.findLoaiSuaByMaLoaiSua(loaiSua.getMaLoaiSua()));
        if (loaiSuaOptional.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        loaiSuaRepository.createLoaiSua(loaiSua);
    }

    @Override
    public void updateLoaiSua(LoaiSua loaiSua,String maLoaiSua) {
        Optional<LoaiSua> loaiSuaOptional =
                Optional.ofNullable(loaiSuaRepository.findLoaiSuaByMaLoaiSua(maLoaiSua));
        if (loaiSuaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E203);
        }
        loaiSuaRepository.updateLoaiSua(loaiSua);
    }

    @Override
    public void deleteLoaiSua(String maLoaiSua) {
        Optional<LoaiSua> loaiSuaOptional = Optional.ofNullable(this.findLoaiSuaByMaLoaiSua(maLoaiSua));
        if (loaiSuaOptional.isEmpty()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        loaiSuaRepository.deleteLoaiSua(loaiSuaOptional.get());
    }
}
