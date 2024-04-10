package com.example.demoCRUD.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkBranch {
    @NotEmpty(message = "maHangSua cannot be null")
    private String milkBranchId;
    @NotEmpty(message = "maHangSua cannot be null")
    private String milkBranchName;
    private String address;
    private String phone;
    private String email;
    private List<Milk> milks;
}
