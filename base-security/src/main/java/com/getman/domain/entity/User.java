package com.getman.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * JPA entity describing user.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class User {

    private static final long serialVersionUID = 2027317675372583895L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 4, max = 20)
    private String name;

    @JsonIgnore
    @NotNull
    @Column(name = "password_hash", updatable = false)
    private String passwordHash;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "jt_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String passwordHash, Set<Role> roles) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
