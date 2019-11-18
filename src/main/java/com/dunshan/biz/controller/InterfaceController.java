package com.dunshan.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@RestController
@RequestMapping(value = "/interface")
public class InterfaceController {

  @GetMapping("/hello")
  @ResponseBody
  public String hello() {
    return "this is pc";
  }

}
