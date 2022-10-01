package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.exception.EntityInTransientStateException;
import org.hibernate.Hibernate;
import javax.persistence.*;

@MappedSuperclass
// http://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    protected AbstractBaseEntity() {
    }

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        if (id == null)
            throw new EntityInTransientStateException("You can't use equals/hashCode contract on transient entity");
        return id;
    }
}