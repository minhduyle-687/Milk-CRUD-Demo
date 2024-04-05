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
@RequestMapping("/loaisua")
public class LoaiSuaController {
    @Autowired
    private LoaiSuaService loaiSuaService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllLoaiSua() {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.getAllLoaiSua());
    }

    @GetMapping("/find/{maLoaiSua}")
    public ResponseEntity<?> findLoaiSuaByMaLoaiSua(@PathVariable("maLoaiSua") String maLoaiSua) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(maLoaiSua);
        if (optionalLoaiSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalLoaiSua.get());
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @GetMapping("/search/{tenLoaiSua}")
    public ResponseEntity<?> searchLoaiSuaByTenLoaiSua(@PathVariable("tenLoaiSua") String tenLoaiSua) {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.searchLoaiSuaByTenLoaiSua(tenLoaiSua));
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

    @PutMapping("/update/{maLoaiSua}")
    public ResponseEntity<?> updateLoaiSua(@RequestBody LoaiSua loaiSua,
                                           @PathVariable("maLoaiSua") String maLoaiSua) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(maLoaiSua);
        if (optionalLoaiSua.isPresent()) {
            loaiSuaService.updateLoaiSua(loaiSua);
            return ResponseEntity.status(HttpStatus.OK).body(loaiSua);
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @DeleteMapping("/delete/{maLoaiSua}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("maLoaiSua") String maLoaiSua) {
        Optional<LoaiSua> optionalLoaiSua = loaiSuaService.findLoaiSuaByMaLoaiSua(maLoaiSua);
        if (optionalLoaiSua.isPresent()) {
            loaiSuaService.deleteLoaiSua(maLoaiSua);
            return ResponseEntity.status(HttpStatus.OK).body(maLoaiSua + " has been deleted.");
        }
        throw new CustomException(CustomErrorCode.E203);
    }
}
