package com.apps.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Setter
public class Stat {

    //annotation for getting 'id' when object is added
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "completed_total")
    private Long completedTotal;
    @Basic
    @Column(name = "uncompleted_total")
    private Long uncompletedTotal;

    public Long getId() {
        return id;
    }

    public Long getCompletedTotal() {
        return completedTotal;
    }

    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

}
