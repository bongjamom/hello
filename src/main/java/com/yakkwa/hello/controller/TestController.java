package com.yakkwa.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yakkwa.hello.dto.ResponseDTO;
import com.yakkwa.hello.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {

  @GetMapping
  public String testController() {
    return "Hello world";
  }

  @GetMapping("/testGetMapping")
  public String testControllerWithPath() {
    return "Hello World! testGetMapping";
  }

  @GetMapping("{id}")
  public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
    return "Hello World! ID : " + id;
  }

  // int로 지정했을 때 값을 지정하지 않으면 500 에러 발생..null값으로 뜨게 하려면 Integer로 지정
  @GetMapping("requestParam")
  public String testControllerRequestParam(@RequestParam(defaultValue = "20") int id) {
    return "Hello World! ID : " + id;
  }

  @GetMapping("requestBody")
  public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
    return "Hello world id : " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
  }

  @GetMapping("requestDTO")
  public String testControllerDTO(TestRequestBodyDTO testRequestBodyDTO) {
    return "Hello world id : " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
  }

  @GetMapping("testResponseBody")
  public ResponseDTO<String> testControllerResponseBody() {
    List<String> list = new ArrayList<>();
    list.add("Hello World! I'm ResponseDTO");
    ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
    return response;
  }

  @GetMapping("testResponseEntity")
  public ResponseEntity<?> testControllerResponseEntity() {
    List<String> list = new ArrayList<>();
    list.add("Hello World! I'm ResponseEntity. And you got 400!");
    ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
    return ResponseEntity.badRequest().body(response);
  }
}
