/** Copyright 2020 bejson.com */
package com.atguigu.gulimall.product.vo;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Auto-generated: 2020-05-31 11:3:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

@Data
public class Attr {

  private Long attrId;
  private String attrName;
  private String attrValue;
  public static void main(String[] args) {
    String password = "admin";
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    System.out.println(encoder.encode(password));
    System.out.println(encoder.encode(password));
  }
}
