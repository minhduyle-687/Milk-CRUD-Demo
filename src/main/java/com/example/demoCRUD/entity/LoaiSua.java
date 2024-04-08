package com.example.demoCRUD.entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiSua {
    @NotEmpty
    private String maLoaiSua;
    @NotEmpty
    private String tenLoaiSua;
    private List<Sua> suas;
}
