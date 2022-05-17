package com.apps.tasklist.backendspringboot.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task", schema = "tasklist", catalog = "")
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "completed", nullable = true)
    private Integer completed;
    @Basic
    @Column(name = "date", nullable = true)
    private Timestamp date;
    @Basic
    @Column(name = "priority_id", nullable = true)
    private Long priorityId;
    @Basic
    @Column(name = "category_id", nullable = true)
    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private PriorityEntity priorityByPriorityId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity categoryByCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (completed != null ? !completed.equals(that.completed) : that.completed != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (priorityId != null ? !priorityId.equals(that.priorityId) : that.priorityId != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completed != null ? completed.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }

    public PriorityEntity getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(PriorityEntity priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
