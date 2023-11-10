package de.huehnerlady.demo.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TestHttpController {

  public TestHttpController() {
  }

  @RequestMapping(method = GET, value = "/test", produces = APPLICATION_JSON_VALUE)
  public TestObject test() {
    TestObject testObject = new TestObject();
    // testObject.setLastResponse(LocalDateTime.parse("2021-05-10T16:40:55"));
    testObject.setLastResponse("2023-11-10T14:03:53123456");
    // testObject.setLastResponse("2021-05-10T16:40:55");
    return testObject;
  }
}
