package com.example.demoCRUD.dto;

import com.example.demoCRUD.entity.HangSua;
import com.example.demoCRUD.entity.LoaiSua;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//Use for insert and update sua to sql
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuaDto {
    @NotEmpty
    private String maSua;
    @NotEmpty
    private String tenSua;
    @NotEmpty
    private String maHangSua;
    @NotEmpty
    private String maLoaiSua;
    @NotEmpty
    private int trongLuong;
    @NotEmpty
    private int donGia;
    private String tpDinhDuong;
    private String loiIch;
    private String hinh;
}
