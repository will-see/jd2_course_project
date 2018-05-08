package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GenericGenerator(name = "item-book",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "book"))
    @GeneratedValue(generator = "item-book")
    @Column(name = "ITEM_ID")
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORMULAR_ID")
    private Formular formular;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

}