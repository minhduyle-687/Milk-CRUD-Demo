package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.HangSuaService;
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

    @GetMapping("/find/{milkBranchId}")
    public ResponseEntity<?> findHangSuaByMaHangSua(@PathVariable("milkBranchId") String milkBranchId) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(milkBranchId);
        if (optionalHangSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalHangSua.get());
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @GetMapping("/search/{milkBranchName}")
    public ResponseEntity<?> searchHangSuaByTenHangSua(@PathVariable("milkBranchName") String milkBranchName) {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.searchHangSuaByTenHangSua(milkBranchName));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createHangSua(@RequestBody HangSua hangSua) {
        Optional<HangSua> optionalHangSua =
                hangSuaService.findHangSuaByMaHangSua(hangSua.getMaHangSua());
        if (optionalHangSua.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        hangSuaService.createHangSua(hangSua);
        return ResponseEntity.status(HttpStatus.CREATED).body(hangSua);
    }

    @PutMapping("/update/{milkBranchId}")
    public ResponseEntity<?> updateHangSua(@RequestBody HangSua hangSua,
                                           @PathVariable("milkBranchId") String milkBranchId) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(milkBranchId);
        if (optionalHangSua.isPresent()) {
            hangSuaService.updateHangSua(hangSua);
            return ResponseEntity.status(HttpStatus.OK).body(hangSua);
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @DeleteMapping("/delete/{milkBranchId}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("milkBranchId") String milkBranchId) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(milkBranchId);
        if (optionalHangSua.isPresent()) {
            hangSuaService.deleteHangSua(milkBranchId);
            return ResponseEntity.status(HttpStatus.OK).body(milkBranchId + " has been deleted.");
        }
        throw new CustomException(CustomErrorCode.E203);
    }
}
