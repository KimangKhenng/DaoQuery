package com.tfd.daoquery.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public
class Note {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "USERNAME")
    private String name;

    @NotNull
    private int repos;

    @NotNull
    private int space;

    @Transient
    private int tempUsageCount;

    @Generated(hash = 2101298997)
    public Note(Long id, String name, int repos, int space) {
        this.id = id;
        this.name = name;
        this.repos = repos;
        this.space = space;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepos() {
        return this.repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public int getSpace() {
        return this.space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}