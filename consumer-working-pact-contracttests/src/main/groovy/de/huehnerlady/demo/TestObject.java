package de.huehnerlady.demo;

import java.time.LocalDateTime;

public class TestObject {

  private LocalDateTime lastResponse;


  public TestObject() {
  }

  public LocalDateTime getLastResponse() {
    return lastResponse;
  }

  public void setLastResponse(LocalDateTime lastResponse) {
    this.lastResponse = lastResponse;
  }
}
