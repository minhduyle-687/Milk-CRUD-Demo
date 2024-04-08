package com.example.demoCRUD.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HangSua {
    @NotEmpty(message = "maHangSua cannot be null")
    private String maHangSua;
    @NotEmpty(message = "maHangSua cannot be null")
    private String tenHangSua;
    private String diaChi;
    private String dienThoai;
    private String email;
    private List<Sua> suas;
}
