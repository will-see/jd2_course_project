package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    private String roleId;
    @Column (name = "ROLE_NAME")
    private String roleName;

    @OneToOne(mappedBy = "role", cascade = {CascadeType.ALL})
    private User user;
}
