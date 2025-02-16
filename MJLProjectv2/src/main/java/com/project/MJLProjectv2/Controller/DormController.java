package com.project.MJLProjectv2.Controller;


import com.project.MJLProjectv2.doubleRange;
import com.project.MJLProjectv2.Entity.Dorm;
import com.project.MJLProjectv2.Service.DormService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dorm")
public class DormController {


 @Autowired // Dependency Injection
 DormService dormService;


 //Different ways to get input from controller:
    //  @RequestBody - request payload
    //  @PathVariable - in the URI as seen below
    //  @RequestParam - in the URI. Ex:https://localhost:8080/dog/add?breed=Beagle
//  @PostMapping("/add/{age}") // entire URI is https://localhost:8080/dog/add
//  public Dorm addDorm(@RequestBody Dorm newDorm){
//    return dormService.addNewDorm(newDorm, breed, age);
//  }


//  @GetMapping("/retrieveDorm/{name}")
//  public Dorm getDorm(@PathVariable("name") String name){
//     return dormService.getDorm(name);
//  }

  @GetMapping("/type/{type}/price/{price}/southeast/{southeast}")
  public List<Dorm> getDorms(@PathVariable("type") String type, @PathVariable("price") double price,
      @PathVariable("southeast") boolean southeast) {
    return dormService.getDorms(type, price, southeast);
  }

  // @GetMapping("/type/{type}")
  // public List<Dorm> getDorms(@PathVariable("type") String type, @RequestBody doubleRange priceRange) {
  //   return dormService.getDorms(type, priceRange.getMinVal());
  // }  

  @GetMapping("/type/{type}/price/{price}")
  public List<Dorm> getDorms(@PathVariable("type") String type, @PathVariable("price") double price) {
    return dormService.getDorms(type, price);
  } 

  @GetMapping("/price/{price}/southeast/{southeast}")
  public List<Dorm> getDorms(@PathVariable("price") double price, @PathVariable("southeast") boolean southeast) {
    return dormService.getDorms(price, southeast);
  } 

  @GetMapping("/price/{price}")
  public List<Dorm> getDorms(@PathVariable("price") double price) {
    return dormService.getDorms(price);
  }

  @GetMapping("/retrieveDorm/all")
  public List<Dorm> getDorms() {
    return dormService.getAllDorms();
  }
  // public Dorm[] getDorm(@)
 //@DeleteMapping
 //@PutMapping
}