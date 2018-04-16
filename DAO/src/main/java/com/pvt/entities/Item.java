package com.pvt.entities;

public class Item {
    private long itemId;
    private long formularId;
    private long bookId;

    public Item() {
    }

    public Item( long formularId, long bookId) {
        this.formularId = formularId;
        this.bookId = bookId;
    }

    public long getId() {
        return itemId;
    }

    public void setId(long itemId) {
        this.itemId = itemId;
    }

    public long getFormularId() {
        return formularId;
    }

    public void setFormularId(long formularId) {
        this.formularId = formularId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}