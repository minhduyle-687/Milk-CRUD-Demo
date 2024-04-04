package com.example.demoCRUD.entity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiSua {
    private String maLoaiSua;
    private String tenLoaiSua;
    private List<Sua> suas;
}
