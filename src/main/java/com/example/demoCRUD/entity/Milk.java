package com.example.demoCRUD.entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Milk {
    private String milkId;
    private String milkName;

    private MilkBranch milkBranch;
    private MilkType milkType;

    private int weight;
    private int price;
    private String nutritionFacts;
    private String benefits;
    private String picture;
}
