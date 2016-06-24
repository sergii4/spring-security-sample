package com.getman.domain.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * JPA entity describing user role.
 */
@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Role {

    private static final long serialVersionUID = -3554101614817184171L;

    @Id
    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9_]*$")
    @Size(min = 4, max = 20)
    private String name;

    @NotNull
    @ElementCollection(targetClass = Permission.class)
    @CollectionTable(name = "permissions", joinColumns = {@JoinColumn(name = "role_id")})
    @Column(name = "permission_id", updatable = false)
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
