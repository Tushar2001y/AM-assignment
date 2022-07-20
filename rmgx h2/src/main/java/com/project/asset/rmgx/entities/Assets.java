package com.project.asset.rmgx.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "Assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer assetId;
    private String name;
    private Date PurchaseDate;
    private String ConditionNote;
    private String AssignmentStatus;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
