package com.bikash.blogging.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String email;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "following_list", joinColumns = @JoinColumn(name = "following_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> followings;
}

