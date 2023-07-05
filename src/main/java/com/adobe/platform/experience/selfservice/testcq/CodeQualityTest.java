package com.adobe.platform.experience.selfservice.testcq;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeQualityTest {
  private static final String NAME="123";

  public static int MAX_COUNT = 0;
  
  public int task1(int a, int b) {
    return a + b;
  }

  public int task2(int a, int b) {
    int sum = a  + b;
    return sum;
  }

  public void printData(List<String> data) {
    if (data.size() > MAX_COUNT) {
      for (String value : data) {
        System.out.println(value);
      }
    }
  }

  public void processFile(String filePath) {
    try {
      File file = new File(filePath);
      // Other file processing logic...
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
