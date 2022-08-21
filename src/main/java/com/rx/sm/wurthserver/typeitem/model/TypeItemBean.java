package com.rx.sm.wurthserver.typeitem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rx.sm.wurthserver.item.model.ItemBean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class TypeItemBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "typeItem")
    List<ItemBean> item;

    public TypeItemBean() {
    }

    public TypeItemBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeItemBean(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
