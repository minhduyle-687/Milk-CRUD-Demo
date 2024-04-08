package com.example.demoCRUD.dto;

import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.entity.LoaiSua;
import lombok.*;

//Use for insert and update sua to sql
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuaDto {
    private String tenSua;

    private String maHangSua;
    private String maLoaiSua;

    private int trongLuong;
    private int donGia;
    private String tpDinhDuong;
    private String loiIch;
    private String hinh;
}
