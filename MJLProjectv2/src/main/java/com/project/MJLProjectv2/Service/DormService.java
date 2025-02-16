package com.project.MJLProjectv2.Service;

import com.project.MJLProjectv2.doubleRange;
import com.project.MJLProjectv2.Entity.Dorm;
import com.project.MJLProjectv2.Repository.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DormService {


 @Autowired //Dependency Injection
 DormRepository dormRepository;


  public Dorm addNewDorm(Dorm newDorm, String name, String type, int price, boolean isSoutheast){
    if (newDorm == null || name == null || name.isBlank() || type == null || type.isBlank() || price < 0){
      return null;
    }


    Dorm dorm = Dorm.builder()
    .name(newDorm.getName())
    .type(type)
    .priceRange(new doubleRange(price))
    .isSoutheast(isSoutheast)
    .build();
    return dormRepository.save(dorm);
  }


  // public Dorm getDorm(String name) {
  //   return dormRepository.findByName(name);
  // }

  /*
  public Dorm[] getDorms(String type) {
    return dormRepository.findAllByDormType(type);
  }

  public Dorm[] getDorms(double price) {
    return dormRepository.findAllByPriceLessThanEqual(price);
  }

  public Dorm[] getDorms(boolean isSoutheast) {
    return dormRepository.findAllByTypeSoutheast(isSoutheast);
  }
    */

  public Dorm[] getDorms(String type, double price, boolean isSoutheast) {
    return dormRepository.findAllByTypeAndPriceLessThanEqualAndIsSoutheast(type, price, isSoutheast);
  }

  public Dorm[] getDorms(String type, double price) {
    return dormRepository.findAllByTypeAndPriceLessThanEqual(type, price);
  }

  public Dorm[] getAllDorms() {
    return ((Dorm[]) dormRepository.findAll().toArray());
  }
}
