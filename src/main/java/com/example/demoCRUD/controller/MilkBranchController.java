package com.example.demoCRUD.controller;

import com.example.demoCRUD.entity.MilkBranch;
import com.example.demoCRUD.service.MilkBranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/milkbranchs")

public class MilkBranchController {
    @Autowired
    private MilkBranchService milkBranchService;

    @GetMapping("")
    public ResponseEntity<?> getAllMilkBranch() {
        return ResponseEntity.status(HttpStatus.OK).body(milkBranchService.getAllMilkBranch());
    }

    @GetMapping("/{milkBranchId}")
    public ResponseEntity<?> findMilkBranchByMilkBranchId(@PathVariable("milkBranchId") String milkBranchId) {
        return ResponseEntity.status(HttpStatus.OK).body(milkBranchService.findMilkBranchByMilkBranchId(milkBranchId));
    }

    @GetMapping("/search/{milkBranchName}")
    public ResponseEntity<?> searchMilkBranchByMilkBranchName(@PathVariable("milkBranchName") String milkBranchName) {
        return ResponseEntity.status(HttpStatus.OK).body(milkBranchService.searchMilkBranchByMilkBranchName(milkBranchName));
    }

    @PostMapping("")
    public ResponseEntity<?> createMilkBranch(@RequestBody @Valid MilkBranch milkBranch) {
        milkBranchService.createMilkBranch(milkBranch);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{milkBranchId}")
    public ResponseEntity<?> updateMilkBranch(@RequestBody @Valid MilkBranch milkBranch,
                                              @PathVariable("milkBranchId") String milkBranchId) {
        milkBranchService.updateMilkBranch(milkBranch, milkBranchId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{milkBranchId}")
    public ResponseEntity<?> deleteMilkBranch(@PathVariable("milkBranchId") String milkBranchId) {
        milkBranchService.deleteMilkBranch(milkBranchId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
