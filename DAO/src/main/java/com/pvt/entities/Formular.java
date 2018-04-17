package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FORMULARS")
public class Formular implements Serializable{
        @Id
        @GenericGenerator(name = "user-formular",
                strategy = "foreign",
                parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
        @GeneratedValue(generator = "user-formular")
        @Column(name = "FORMULAR_ID")
        private long formularId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn (name = "USER_ID")
        private User user;

        @OneToMany(mappedBy = "formular",cascade = CascadeType.ALL)
        private List<Item> items = new ArrayList<>();
        private long bookId;

}
