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
@RequestMapping("/hangsua")

public class HangSuaController {
    @Autowired
    private HangSuaService hangSuaService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllHangSua() {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.getAllHangSua());
    }

    @GetMapping("/find/{maHangSua}")
    public ResponseEntity<?> findHangSuaByMaHangSua(@PathVariable("maHangSua") String maHangSua) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(maHangSua);
        if (optionalHangSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalHangSua.get());
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @GetMapping("/search/{tenHangSua}")
    public ResponseEntity<?> searchHangSuaByTenHangSua(@PathVariable("tenHangSua") String tenHangSua) {
        return ResponseEntity.status(HttpStatus.OK).body(hangSuaService.searchHangSuaByTenHangSua(tenHangSua));
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

    @PutMapping("/update/{maHangSua}")
    public ResponseEntity<?> updateHangSua(@RequestBody HangSua hangSua,
                                           @PathVariable("maHangSua") String maHangSua) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(maHangSua);
        if (optionalHangSua.isPresent()) {
            hangSuaService.updateHangSua(hangSua);
            return ResponseEntity.status(HttpStatus.OK).body(hangSua);
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @DeleteMapping("/delete/{maHangSua}")
    public ResponseEntity<?> deleteHangSua(@PathVariable("maHangSua") String maHangSua) {
        Optional<HangSua> optionalHangSua = hangSuaService.findHangSuaByMaHangSua(maHangSua);
        if (optionalHangSua.isPresent()) {
            hangSuaService.deleteHangSua(maHangSua);
            return ResponseEntity.status(HttpStatus.OK).body(maHangSua + " has been deleted.");
        }
        throw new CustomException(CustomErrorCode.E203);
    }
}
