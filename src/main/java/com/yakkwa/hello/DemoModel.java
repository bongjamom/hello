package com.yakkwa.hello;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class DemoModel {
  @NonNull
  private String id;

  public static void main(String[] args) {
    DemoModel demoModel = DemoModel.builder().id("abcd").build();
    System.out.println(demoModel);
  }
}
