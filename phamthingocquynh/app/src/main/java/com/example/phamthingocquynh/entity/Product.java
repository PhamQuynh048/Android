package com.example.phamthingocquynh.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int Id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "quantity")
    public int quantity;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
