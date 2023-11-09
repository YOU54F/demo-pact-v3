package de.huehnerlady.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestOperations

import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.MediaType.APPLICATION_JSON

class TestService {

  Logger logger = LoggerFactory.getLogger(getClass())

  String url
  RestOperations restOperations

  HttpHeaders headers = new HttpHeaders(accept: [APPLICATION_JSON], contentType: APPLICATION_JSON)

  TestObject test() {
    try {
      ResponseEntity<TestObject> responseEntity =
          restOperations.exchange(url + "/test", GET,
                                  new HttpEntity<Object>(headers), TestObject)
      return responseEntity.body
    }
    catch (Exception e) {
      return null
    }
  }
}
