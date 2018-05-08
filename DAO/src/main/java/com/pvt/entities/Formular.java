package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@ToString(of = "formularId")
public class Formular implements Serializable{
        @Id
//        @GenericGenerator(name = "user-formular",
//                strategy = "foreign",
//                parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "FORMULAR_ID")
        private Long formularId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn (name = "USER_ID")
        private User user;

//        @OneToMany(fetch = FetchType.EAGER, mappedBy = "formular",cascade = CascadeType.ALL)
//        private List<Book> items = new ArrayList<>();

        @ManyToMany(mappedBy = "formulars")
        private List<Book> books = new ArrayList<Book>();

}
