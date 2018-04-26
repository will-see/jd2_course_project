package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column (name = "ROLE_NAME")
    private String roleName;

    @OneToOne(mappedBy = "role", cascade = {CascadeType.ALL})
    private User user;
}
