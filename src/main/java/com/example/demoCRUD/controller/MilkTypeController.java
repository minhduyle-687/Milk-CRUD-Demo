package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.LoaiSua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.LoaiSuaService;
import jakarta.validation.Valid;
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

    @GetMapping("/{milkTypeId}")
    public ResponseEntity<?> findLoaiSuaByMaLoaiSua(@PathVariable("milkTypeId") String milkTypeId) {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.findLoaiSuaByMaLoaiSua(milkTypeId));
    }

    @GetMapping("/search/{milkTypeName}")
    public ResponseEntity<?> searchLoaiSuaByTenLoaiSua(@PathVariable("milkTypeName") String milkTypeName) {
        return ResponseEntity.status(HttpStatus.OK).body(loaiSuaService.searchLoaiSuaByTenLoaiSua(milkTypeName));
    }

    @PostMapping("/")
    public ResponseEntity<?> createLoaiSua(@RequestBody @Valid LoaiSua loaiSua) {
        loaiSuaService.createLoaiSua(loaiSua);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkTypeId}")
    public ResponseEntity<?> updateLoaiSua(@RequestBody @Valid LoaiSua loaiSua,
                                           @PathVariable("milkTypeId") String milkTypeId) {
        loaiSuaService.updateLoaiSua(loaiSua, milkTypeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkTypeId}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("milkTypeId") String milkTypeId) {
        loaiSuaService.deleteLoaiSua(milkTypeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
