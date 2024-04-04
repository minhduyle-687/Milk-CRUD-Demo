package com.example.demoCRUD.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HangSua {
    private String maHangSua;
    private String tenHangSua;
    private String diaChi;
    private String dienThoai;
    private String email;
    private List<Sua> suas;
}
