package com.example.demoCRUD.service.impl;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.entity.MilkBranch;
import com.example.demoCRUD.exception.CustomException;
import com.example.demoCRUD.repository.MilkBranchRepository;
import com.example.demoCRUD.service.MilkBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilkBranchServiceImpl implements MilkBranchService {
    @Autowired
    private MilkBranchRepository milkBranchRepository;

    @Override
    public List<MilkBranch> getAllMilkBranch() {
        return milkBranchRepository.getAllMilkBranch();
    }

    @Override
    public MilkBranch findMilkBranchByMilkBranchId(String maHangSua) {
        Optional<MilkBranch> hangSuaOptional =
                Optional.ofNullable(milkBranchRepository.findMilkBranchByMilkBranchId(maHangSua));
        return hangSuaOptional.orElseThrow(() -> new CustomException(CustomErrorCode.E203));
    }

    @Override
    public List<MilkBranch> searchMilkBranchByMilkBranchName(String tenHangSua) {
        return milkBranchRepository.searchMilkBranchByMilkBranchName(tenHangSua);
    }

    @Override
    public void createMilkBranch(MilkBranch milkBranch) {
        Optional<MilkBranch> hangSuaOptional =
                Optional.ofNullable(milkBranchRepository.findMilkBranchByMilkBranchId(milkBranch.getMilkBranchId()));
        if (hangSuaOptional.isPresent())
            throw new CustomException(CustomErrorCode.E209);
        milkBranchRepository.createMilkBranch(milkBranch);
    }

    @Override
    public void updateMilkBranch(MilkBranch milkBranch, String maHangSua) {
        Optional<MilkBranch> hangSuaOptional =
                Optional.ofNullable(milkBranchRepository.findMilkBranchByMilkBranchId(maHangSua));
        if (hangSuaOptional.isEmpty())
            throw new CustomException(CustomErrorCode.E203);
        milkBranchRepository.updateMilkBranch(milkBranch);
    }

    @Override
    public void deleteMilkBranch(String maHangSua) {
        Optional<MilkBranch> hangSuaOptional =
                Optional.ofNullable(milkBranchRepository.findMilkBranchByMilkBranchId(maHangSua));
        if (hangSuaOptional.isEmpty())
            throw new CustomException(CustomErrorCode.E203);
        milkBranchRepository.deleteMilkBranch(hangSuaOptional.get());
    }
}
