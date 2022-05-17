package com.apps.tasklist.backendspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "stat", schema = "tasklist", catalog = "")
public class StatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "completed_total", nullable = true)
    private Long completedTotal;
    @Basic
    @Column(name = "uncompleted_total", nullable = true)
    private Long uncompletedTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompletedTotal() {
        return completedTotal;
    }

    public void setCompletedTotal(Long completedTotal) {
        this.completedTotal = completedTotal;
    }

    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

    public void setUncompletedTotal(Long uncompletedTotal) {
        this.uncompletedTotal = uncompletedTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatEntity that = (StatEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (completedTotal != null ? !completedTotal.equals(that.completedTotal) : that.completedTotal != null)
            return false;
        if (uncompletedTotal != null ? !uncompletedTotal.equals(that.uncompletedTotal) : that.uncompletedTotal != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (completedTotal != null ? completedTotal.hashCode() : 0);
        result = 31 * result + (uncompletedTotal != null ? uncompletedTotal.hashCode() : 0);
        return result;
    }
}
