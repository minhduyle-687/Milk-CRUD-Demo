package com.example.demoCRUD.controller;

import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.LoaiSua;
import com.example.demoCRUD.entity.Sua;
import com.example.demoCRUD.service.SuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sua")
public class SuaController {
    @Autowired
    private SuaService suaService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllSua() {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.getAllSua());
    }

    @GetMapping("/find/{maSua}")
    public ResponseEntity<?> findSuaByMaSua(@PathVariable("maSua") String maSua) {
        Optional<Sua> optionalSua = suaService.findSuaByMaSua(maSua);
        if (optionalSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalSua.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ma sua not found!!");
    }

    @GetMapping("/search-tensua/{tenSua}")
    public ResponseEntity<?> searchSuaByTenSua(@PathVariable("tenSua") String tenSua) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchSuaByTenSua(tenSua));
    }

    @GetMapping("/search-mahangsua/{maHangSua}")
    public ResponseEntity<?> searchSuaByMaHangSua(@PathVariable("maHangSua") String maHangSua) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchSuaByMaHangSua(maHangSua));
    }

    @GetMapping("/search-maloaisua/{maLoaiSua}")
    public ResponseEntity<?> searchSuaByMaLoaiSua(@PathVariable("maLoaiSua") String maLoaiSua) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchSuaByMaLoaiSua(maLoaiSua));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createSua(@RequestBody SuaDto suaDto) {
        Optional<Sua> optionalSua = suaService.findSuaByMaSua(suaDto.getMaSua());
        if (optionalSua.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ma sua has existed. " +
                    "Please change different ma sua!!");
        }
        suaService.createSua(suaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(suaDto);
    }

    @PutMapping("/update/{maSua}")
    public ResponseEntity<?> updateSua(@RequestBody SuaDto suaDto,
                                           @PathVariable("maSua") String maSua) {
        Optional<Sua> optionalSua = suaService.findSuaByMaSua(maSua);
        if (optionalSua.isPresent()) {
            suaService.updateSua(suaDto);
            return ResponseEntity.status(HttpStatus.OK).body(suaDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ma sua not found!!");
    }

    @DeleteMapping("/delete/{maSua}")
    public ResponseEntity<?> deleteSua(@PathVariable("maSua") String maSua) {
        Optional<Sua> optionalSua = suaService.findSuaByMaSua(maSua);
        if (optionalSua.isPresent()) {
            suaService.deleteSua(maSua);
            return ResponseEntity.status(HttpStatus.OK).body(maSua + " has been deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ma sua not found!!");
    }
}
