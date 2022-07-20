package com.project.asset.rmgx.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "employee_name",nullable = false, length = 100)
    private String full_name;
    private String designation;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Assets> assets = new ArrayList<>();
}
