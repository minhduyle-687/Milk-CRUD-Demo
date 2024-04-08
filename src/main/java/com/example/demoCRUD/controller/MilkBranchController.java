package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.HangSuaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/milkbranchs")

public class MilkBranchController {
    @Autowired
    private HangSuaService hangSuaService;

    @GetMapping("/")
    public ResponseEntity<?> getAllHangSua() {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.getAllHangSua());
    }

    @GetMapping("/{milkBranchId}")
    public ResponseEntity<?> findHangSuaByMaHangSua(@PathVariable("milkBranchId") String milkBranchId) {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.findHangSuaByMaHangSua(milkBranchId));
    }

    @GetMapping("/search/{milkBranchName}")
    public ResponseEntity<?> searchHangSuaByTenHangSua(@PathVariable("milkBranchName") String milkBranchName) {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.searchHangSuaByTenHangSua(milkBranchName));
    }

    @PostMapping("/")
    public ResponseEntity<?> createHangSua(@RequestBody @Valid HangSua hangSua) {
        hangSuaService.createHangSua(hangSua);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkBranchId}")
    public ResponseEntity<?> updateHangSua(@RequestBody @Valid HangSua hangSua,
                                           @PathVariable("milkBranchId") String milkBranchId) {
        hangSuaService.updateHangSua(hangSua, milkBranchId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkBranchId}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("milkBranchId") String milkBranchId) {
        hangSuaService.deleteHangSua(milkBranchId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
