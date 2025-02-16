package com.project.MJLProjectv2;

import com.project.MJLProjectv2.Entity.Dorm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DormPlaceholder {
  private String name;
  private String type;
  private doubleRange priceRange;
  private boolean isSouthEast;

  public void updatePrice(double newPrice) {
    priceRange.addValue(newPrice);
  }

  public Dorm dorm() {
    
    return Dorm.builder()
    .name(name)
    .type(type)
    .priceRange(priceRange)
    .isSoutheast(isSouthEast)
    .price(priceRange.getMinVal())
    .build();
  }
}
