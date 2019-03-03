package com.moss.algorithm.removeinterview._sample_02;

import java.util.Scanner;

class myCode
{
  public static void main (String[] args) throws java.lang.Exception
  {
    // 입력
    Scanner scanner = new Scanner(System.in);
    Integer length = scanner.nextInt();
    
    // 출력
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
        builder.append("Hello\n");
    }
    System.out.println(builder.toString());
    
    scanner.close();
  }
}
