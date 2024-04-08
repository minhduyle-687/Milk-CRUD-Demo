package com.example.demoCRUD.controller;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.SuaDto;
import com.example.demoCRUD.entity.Sua;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.service.SuaService;
import jakarta.validation.Valid;
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
        return ResponseEntity.status(HttpStatus.OK).body(suaService.findMilkByMilkId(milkId));
    }

//    @GetMapping("/search-milkname/{milkName}")
//    public ResponseEntity<?> searchMilkByMilkName(@PathVariable("milkName") String milkName) {
//        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkName(milkName));
//    }
//
//    @GetMapping("/search-milkbranchid/{milkBranchId}")
//    public ResponseEntity<?> searchMilkByMilkBranchId(@PathVariable("milkBranchId") String milkBranchId) {
//        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkBranchId(milkBranchId));
//    }
//
//    @GetMapping("/search-milkTypeId/{milkTypeId}")
//    public ResponseEntity<?> searchMilkByMilkTypeId(@PathVariable("milkTypeId") String milkTypeId) {
//        return ResponseEntity.status(HttpStatus.OK).body(suaService.searchMilkByMilkTypeId(milkTypeId));
//    }

//    @GetMapping("/search/")
//    public ResponseEntity<?>searchMilk(@RequestParam(name = "milkName", required = false) String milkName,
//                                       @RequestParam(name = "milkBranchId", required = false) String milkBranchId,
//                                       @RequestParam(name = "milkTypeId", required = false) String milkTypeId) {
//
//    }

    @PostMapping("/")
    public ResponseEntity<?> createMilk(@RequestBody @Valid SuaDto suaDto) {
        suaService.createMilk(suaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkId}")
    public ResponseEntity<?> updateMilk(@RequestBody @Valid SuaDto suaDto,
                                           @PathVariable("milkId") String milkId) {
        suaService.updateMilk(suaDto, milkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkId}")
    public ResponseEntity<?> deleteMilk(@PathVariable("milkId") String milkId) {
        suaService.deleteMilk(milkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
