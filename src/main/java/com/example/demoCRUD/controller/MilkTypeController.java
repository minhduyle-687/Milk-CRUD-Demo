package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.LoaiSua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.LoaiSuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/milktypes")
public class MilkTypeController {
    @Autowired
    private LoaiSuaService loaiSuaService;

    @GetMapping("/")
    public ResponseEntity<?> getAllLoaiSua() {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.getAllLoaiSua());
    }

    @GetMapping("/find/{milkTypeId}")
    public ResponseEntity<?> findLoaiSuaByMaLoaiSua(@PathVariable("milkTypeId") String milkTypeId) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(milkTypeId);
        if (optionalLoaiSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalLoaiSua.get());
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @GetMapping("/search/{milkTypeName}")
    public ResponseEntity<?> searchLoaiSuaByTenLoaiSua(@PathVariable("milkTypeName") String milkTypeName) {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.searchLoaiSuaByTenLoaiSua(milkTypeName));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createLoaiSua(@RequestBody LoaiSua loaiSua) {
        Optional<LoaiSua> optionalLoaiSua =
                loaiSuaService.findLoaiSuaByMaLoaiSua(loaiSua.getMaLoaiSua());
        if (optionalLoaiSua.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        loaiSuaService.createLoaiSua(loaiSua);
        return ResponseEntity.status(HttpStatus.CREATED).body(loaiSua);
    }

    @PutMapping("/update/{milkTypeId}")
    public ResponseEntity<?> updateLoaiSua(@RequestBody LoaiSua loaiSua,
                                           @PathVariable("milkTypeId") String milkTypeId) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(milkTypeId);
        if (optionalLoaiSua.isPresent()) {
            loaiSuaService.updateLoaiSua(loaiSua);
            return ResponseEntity.status(HttpStatus.OK).body(loaiSua);
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @DeleteMapping("/delete/{milkTypeId}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("milkTypeId") String milkTypeId) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(milkTypeId);
        if (optionalLoaiSua.isPresent()) {
            loaiSuaService.deleteLoaiSua(milkTypeId);
            return ResponseEntity.status(HttpStatus.OK).body(milkTypeId + " has been deleted.");
        }
        throw new CustomException(CustomErrorCode.E203);
    }
}
