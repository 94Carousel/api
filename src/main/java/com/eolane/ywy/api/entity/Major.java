package com.eolane.ywy.api.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_major")
@Entity
@Proxy(lazy = false)
public class Major implements Serializable{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 专业名称
     */
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
