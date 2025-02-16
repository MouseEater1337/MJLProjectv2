package com.project.MJLProjectv2;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class doubleRange {

  private Double minVal;
  private Double maxVal;

  public doubleRange(double min) {
    minVal = min;
    maxVal  = min;
  }

  public void addValue(double d) {
    if(minVal == null)
      minVal = d;
    else if(maxVal == null) {
      if(d > minVal) maxVal = d;
      else {
        maxVal = minVal;
        minVal = d;
      }
    }
    else {
      minVal = Math.min(minVal, d);
      maxVal = Math.max(maxVal, d);
    }
  }

  public double getMinVal() {
    return minVal;
  }

  public double getMaxVal() {
    return maxVal;
  }

  public String toString() {
    String output = "";
    if(minVal != null) {
      output += minVal;
    }
    if(maxVal != minVal) {
      output += " - " + maxVal;
    }
    return output;
  }
}
