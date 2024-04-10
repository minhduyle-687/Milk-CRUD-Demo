package com.example.demoCRUD.entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkType {
    @NotEmpty
    private String milkTypeId;
    @NotEmpty
    private String milkTypeName;
    private List<Milk> milks;
}
