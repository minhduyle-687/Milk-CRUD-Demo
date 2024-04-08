package com.example.demoCRUD.entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Sua {
    private String maSua;
    private String tenSua;

    private HangSua hangSua;
    private LoaiSua loaiSua;

    private int trongLuong;
    private int donGia;
    private String tpDinhDuong;
    private String loiIch;
    private String hinh;
}
