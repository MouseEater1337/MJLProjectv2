package com.project.MJLProjectv2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //generate toString, getters, and setters
@Builder
@AllArgsConstructor
@Table(name = "dorm.table")
public class Dorm {
  @Id
  @SequenceGenerator(name = "dorm_seq", sequenceName = "dorm_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dorm_seq")
  @Column(name = "dorm_id")
  private Integer id;

  @Column (name = "name", nullable = false)
  private String name;

  @Column(name = "type", nullable = false)
  private String type;

  @Column (name = "price", nullable = false)
  private double price;

  @Column(name = "isSoutheast", nullable = false)
  boolean isSoutheast;

}
