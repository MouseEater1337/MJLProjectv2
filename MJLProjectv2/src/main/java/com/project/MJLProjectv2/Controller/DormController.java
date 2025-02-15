package com.project.MJLProjectv2.Controller;


import com.project.MJLProjectv2.Entity.Dorm;
import com.project.MJLProjectv2.Service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dorm")
public class DormController {


 @Autowired // Dependency Injection
 DormService dormService;


 //Different ways to get input from controller:
     //@RequestBody - request payload
     //@PathVariable - in the URI as seen below
     //@RequestParam - in the URI. Ex:https://localhost:8080/dog/add?breed=Beagle
//  @PostMapping("/add/{age}") // entire URI is https://localhost:8080/dog/add
//  public Dorm addDorm(@RequestBody Dorm newDorm, @RequestParam("breed") String breed,
//    @PathVariable("age") int age){
//    return dormService.addNewDorm(newDorm, breed, age);
//  }


 @GetMapping("/retrieveDog/{name}")
 public Dorm getDog(@PathVariable("name") String name){
   return dormService.getDorm(name);
 }


 //@DeleteMapping
 //@PutMapping
}