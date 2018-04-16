package com.pvt.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Formular {
        private long formularId;
        private long userId;
        private List<Item> items = new ArrayList<>();
        private long bookId;

}
