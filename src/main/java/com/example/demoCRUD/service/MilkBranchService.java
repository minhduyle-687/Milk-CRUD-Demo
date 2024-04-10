package com.example.demoCRUD.service;


import com.example.demoCRUD.entity.MilkBranch;

import java.util.List;

public interface MilkBranchService {
    List<MilkBranch> getAllMilkBranch();

    MilkBranch findMilkBranchByMilkBranchId(String milkBranchId);

    List<MilkBranch> searchMilkBranchByMilkBranchName(String milkBranchName);

    void createMilkBranch(MilkBranch milkBranch);

    void updateMilkBranch(MilkBranch milkBranch, String milkBranchId);

    void deleteMilkBranch(String milkBranchName);
}
