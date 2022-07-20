package com.project.asset.rmgx.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AssetDto {
    private Integer assetId;
    private String name;
    private Date PurchaseDate;
    private String ConditionNote;
    private String AssignmentStatus;
    private CategoryDto category;
    private UserDto user;
}
