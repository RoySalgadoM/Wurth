package com.rx.sm.wurthserver.item.model;

import com.rx.sm.wurthserver.typeitem.model.TypeItemBean;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private int price;
    private double weight;
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private TypeItemBean typeItem;

    public ItemBean() {
    }

    public ItemBean(long id, String name, int price, double weight, TypeItemBean typeItem) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.typeItem = typeItem;
    }

    public ItemBean(String name, int price, double weight, TypeItemBean typeItem) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.typeItem = typeItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public TypeItemBean getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItemBean typeItem) {
        this.typeItem = typeItem;
    }
}
