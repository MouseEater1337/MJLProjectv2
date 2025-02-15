package com.project.MJLProjectv2.Repository;


import com.project.MJLProjectv2.Entity.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DormRepository extends JpaRepository<Dorm, Integer> {


  //Search up Spring JPA Naming Conventions for more details
  Dorm findByName(String name);

  //find by dorm type
  Dorm[] findAllByDormType(String type);

  //find by budget
  Dorm[] findAllByPriceLessThanEqual(double price);

  //find by southeast/lakeshore
  Dorm[] findAllByTypeSoutheast(boolean type);

  //Can write really complex queries with native MySQL like so - search up Spring custom queries for more
  //@Query(nativeQuery = true, value = "Complex MySQL Query Here")
  //Dog findByNameAndBreedIsLike(String name, String breed);




}
