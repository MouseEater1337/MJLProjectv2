package com.project.MJLProjectv2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.project.MJLProjectv2.Entity.Dorm;
import com.project.MJLProjectv2.Repository.DormRepository;

import jakarta.annotation.PostConstruct;
import java.util.*;
import java.io.*;

@Component
public class Startup {
  @Autowired
  private DormRepository dr;

  @PostConstruct
  public void init() {
    // Logic to be executed at startup
    System.out.flush();
    System.out.println("Application started");
    readData("Datasheet.csv");
  }

  private String cutQuotes(String s) {
    for(int i = 0; i < s.length(); i++) {
        if(s.substring(i, i+1).equals("\"")) {
            s = s.substring(0, i) + s.substring(i+1);
        }  
    }
    return s;
  }

  private String[] lineParser(String line, int len) {
    int quoteCount = 0;
    int index = 0;
    String[] output = new String[len];
    String currentString = "";
    for(int i = 0; i < line.length(); i++) {
        String s = line.substring(i, i+1);
        if(s.equals(",")) {
            if(quoteCount % 2 == 0) {
                currentString = cutQuotes(currentString);
                output[index] = currentString;
                index++;
                quoteCount = 0;
                currentString = "";
            }
            else
            currentString += s;
        }
        else{
            if(s.equals("\""))
                quoteCount++;
                currentString += s;
        }
    }
    output[len-1] = currentString;
    return output;
}

  private double readDouble(String s) {
    return Double.parseDouble(s.replace(",", ""));
  }

  private void readData(String filename) {
    /*
    Scanner in;
    try{
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Datasheet.csv");
      if (inputStream == null) {
          throw new FileNotFoundException("Datasheet.csv not found in resources");
      }
      in = new Scanner(inputStream);
    }
    catch(Exception e) {
      return;
    }
      */
      
    HashMap<String, DormPlaceholder> map = new HashMap<String, DormPlaceholder>();
    try {
      // Load the file from the resources folder
      Resource resource = new ClassPathResource("Datasheet.csv");

      // Open the file using BufferedReader
      try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
          String line;
          while ((line = br.readLine()) != null) {
              // Split line using StringTokenizer
              String[] parsedLine = lineParser(line, 5);
              String name = parsedLine[0];
              String type = (new StringTokenizer(parsedLine[1])).nextToken();
              double price = readDouble(parsedLine[2]);
              boolean isSoutheast = Boolean.parseBoolean(parsedLine[3]);
              String code = (name + type).trim();
              System.out.println(code);
              if(!map.keySet().contains(code)) {
                map.put(code, new DormPlaceholder(name, type, new doubleRange(price), isSoutheast));
              }
              else {
                System.out.println("Dupe Code");
                map.get(code).updatePrice(price);
              }
          }
          Set<String> keySet = map.keySet();
          for(String s : keySet) {
            System.out.println(map.get(s).getPriceRange().toString());
            dr.save(map.get(s).dorm());
          }
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
  /*
    while(in.hasNextLine()) {
      String line = in.nextLine();
      if(line.isEmpty()) continue;
      StringTokenizer st = new StringTokenizer(line, ",");
      String name = st.nextToken();
      String type = (new StringTokenizer(st.nextToken())).nextToken();
      double price = Double.parseDouble(st.nextToken());
      st.nextToken();
      boolean isSoutheast = Boolean.parseBoolean(st.nextToken());
      String code = name + type;
      if(!map.keySet().contains(code)) {
        map.put(name, new DormPlaceholder(name, type, new doubleRange(price), isSoutheast));
      }
      else {
        map.get(code).updatePrice(price);
      }
    }
    Set<String> keySet = map.keySet();
    for(String s : keySet) {
      System.out.println(map.get(s).getPriceRange());
      dr.save(map.get(s).dorm());
    }
    in.close();
    */
  }

}