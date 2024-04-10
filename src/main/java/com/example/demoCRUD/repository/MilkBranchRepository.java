package com.example.demoCRUD.repository;

import com.example.demoCRUD.entity.MilkBranch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MilkBranchRepository {
    List<MilkBranch> getAllMilkBranch();

    MilkBranch findMilkBranchByMilkBranchId(String milkBranchId);

    List<MilkBranch> searchMilkBranchByMilkBranchName(String milkBranchName);

    void createMilkBranch(MilkBranch milkBranch);

    void updateMilkBranch(MilkBranch milkBranch);

    void deleteMilkBranch(MilkBranch milkBranch);
}
