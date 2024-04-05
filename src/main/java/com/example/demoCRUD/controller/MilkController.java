package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.SuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/milks")
public class MilkController {
    @Autowired
    private SuaService suaService;

    @GetMapping("/")
    public ResponseEntity<?> getAllMilk() {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.getAllMilk());
    }

    @GetMapping("/{milkId}")
    public ResponseEntity<?> findMilkByMilkId(@PathVariable("milkId") String milkId) {
        Optional<Sua> optionalMilk = suaService.findMilkByMilkId(milkId);
        if (optionalMilk.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalMilk.get());
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @GetMapping("/search-milkname/{milkName}")
    public ResponseEntity<?> searchMilkByMilkName(@PathVariable("milkName") String milkName) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkName(milkName));
    }

    @GetMapping("/search-milkbranchid/{milkBranchId}")
    public ResponseEntity<?> searchMilkByMilkBranchId(@PathVariable("milkBranchId") String milkBranchId) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkBranchId(milkBranchId));
    }

    @GetMapping("/search-milkTypeId/{milkTypeId}")
    public ResponseEntity<?> searchMilkByMilkTypeId(@PathVariable("milkTypeId") String milkTypeId) {
        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkTypeId(milkTypeId));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createMilk(@RequestBody SuaDto suaDto) {
        Optional<Sua> optionalMilk = suaService.findMilkByMilkId(suaDto.getMaSua());
        if (optionalMilk.isPresent()) {
            throw new CustomException(CustomErrorCode.E209);
        }
        suaService.createMilk(suaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{milkId}")
    public ResponseEntity<?> updateMilk(@RequestBody SuaDto suaDto,
                                           @PathVariable("milkId") String milkId) {
        Optional<Sua> optionalMilk = suaService.findMilkByMilkId(milkId);
        if (optionalMilk.isPresent()) {
            suaService.updateMilk(suaDto);
            return ResponseEntity.status(HttpStatus.OK).body(suaDto);
        }
        throw new CustomException(CustomErrorCode.E203);
    }

    @DeleteMapping("/delete/{milkId}")
    public ResponseEntity<?> deleteMilk(@PathVariable("milkId") String milkId) {
        Optional<Sua> optionalMilk = suaService.findMilkByMilkId(milkId);
        if (optionalMilk.isPresent()) {
            suaService.deleteMilk(milkId);
            return ResponseEntity.status(HttpStatus.OK).body(milkId + " has been deleted.");
        }
        throw new CustomException(CustomErrorCode.E203);
    }
}
