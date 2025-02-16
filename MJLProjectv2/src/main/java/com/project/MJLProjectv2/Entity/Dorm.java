package com.project.MJLProjectv2.Entity;

import com.project.MJLProjectv2.doubleRange;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //generate toString, getters, and setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

  @Column (name = "priceRange", nullable = false)
  @Embedded
  private doubleRange priceRange;

  @Column(name = "isSoutheast", nullable = false)
  private boolean isSoutheast;

  @Column(name = "price", nullable = false)
  private double price;
}
