package com.example.demoCRUD.controller;

import com.example.demoCRUD.dto.MilkDto;
import com.example.demoCRUD.service.MilkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/milks")
public class MilkController {
    @Autowired
    private MilkService milkService;

    @GetMapping("")
    public ResponseEntity<?> getAllMilk() {
        return ResponseEntity.status(HttpStatus.OK).body(milkService.getAllMilk());
    }

    @GetMapping("/{milkId}")
    public ResponseEntity<?> findMilkByMilkId(@PathVariable("milkId") String milkId) {
        return ResponseEntity.status(HttpStatus.OK).body(milkService.findMilkByMilkId(milkId));
    }

//    @GetMapping("/search-milkname/{milkName}")
//    public ResponseEntity<?> searchMilkByMilkName(@PathVariable("milkName") String milkName) {
//        return ResponseEntity.status(HttpStatus.OK).body(milkService.searchMilkByMilkName(milkName));
//    }
//
//    @GetMapping("/search-milkbranchid/{milkBranchId}")
//    public ResponseEntity<?> searchMilkByMilkBranchId(@PathVariable("milkBranchId") String milkBranchId) {
//        return ResponseEntity.status(HttpStatus.OK).body(milkService.searchMilkByMilkBranchId(milkBranchId));
//    }
//
//    @GetMapping("/search-milkTypeId/{milkTypeId}")
//    public ResponseEntity<?> searchMilkByMilkTypeId(@PathVariable("milkTypeId") String milkTypeId) {
//        return ResponseEntity.status(HttpStatus.OK).body(milkService.searchMilkByMilkTypeId(milkTypeId));
//    }

//    @GetMapping("/search/")
//    public ResponseEntity<?>searchMilk(@RequestParam(name = "milkName", required = false) String milkName,
//                                       @RequestParam(name = "milkBranchId", required = false) String milkBranchId,
//                                       @RequestParam(name = "milkTypeId", required = false) String milkTypeId) {
//
//    }

    @PostMapping("")
    public ResponseEntity<?> createMilk(@RequestBody @Valid MilkDto milkDto) {
        milkService.createMilk(milkDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkId}")
    public ResponseEntity<?> updateMilk(@RequestBody @Valid MilkDto milkDto,
                                           @PathVariable("milkId") String milkId) {
        milkService.updateMilk(milkDto, milkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkId}")
    public ResponseEntity<?> deleteMilk(@PathVariable("milkId") String milkId) {
        milkService.deleteMilk(milkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
