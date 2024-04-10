package com.example.demoCRUD.controller;

import com.example.demoCRUD.entity.MilkType;
import com.example.demoCRUD.service.MilkTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/milktypes")
public class MilkTypeController {
    @Autowired
    private MilkTypeService milkTypeService;

    @GetMapping("")
    public ResponseEntity<?> getAllMilkType() {
        return ResponseEntity.status(HttpStatus.OK).body(milkTypeService.getAllMilkType());
    }

    @GetMapping("/{milkTypeId}")
    public ResponseEntity<?> findMilkTypeByMilkTypeId(@PathVariable("milkTypeId") String milkTypeId) {
        return ResponseEntity.status(HttpStatus.OK).body(milkTypeService.findMilkTypeByMilkTypeId(milkTypeId));
    }

    @GetMapping("/search/{milkTypeName}")
    public ResponseEntity<?> searchMilkTypeByMilkTypeName(@PathVariable("milkTypeName") String milkTypeName) {
        return ResponseEntity.status(HttpStatus.OK).body(milkTypeService.searchMilkTypeByMilkTypeName(milkTypeName));
    }

    @PostMapping("")
    public ResponseEntity<?> createMilkType(@RequestBody @Valid MilkType milkType) {
        milkTypeService.createMilkType(milkType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkTypeId}")
    public ResponseEntity<?> updateMilkType(@RequestBody @Valid MilkType milkType,
                                            @PathVariable("milkTypeId") String milkTypeId) {
        milkTypeService.updateMilkType(milkType, milkTypeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkTypeId}")
    public ResponseEntity<?> deleteMilkType(@PathVariable("milkTypeId") String milkTypeId) {
        milkTypeService.deleteMilkType(milkTypeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
