package de.huehnerlady.demo

import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt
import au.com.dius.pact.consumer.junit5.PactTestFor
import au.com.dius.pact.core.model.RequestResponsePact
import au.com.dius.pact.core.model.annotations.Pact
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.web.client.RestTemplate
import au.com.dius.pact.core.model.PactSpecVersion // required for v4.6.x to set pactVersion

import static java.time.Instant.parse
import static org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT
import static org.assertj.core.api.Assertions.assertThat

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "provider", pactVersion = PactSpecVersion.V3) // required for v4.6.x to set pactVersion
@Tag("pact")
class ConsumerPactTest {

  @Pact(consumer = "Consumer-Working")
  RequestResponsePact provider(PactDslWithProvider builder) {
    return builder
        .uponReceiving("consumer-test")
        .method("GET")
        .path("/test")
        .willRespondWith()
        .status(200)
        .body(new PactDslJsonBody()
                  .datetime("lastResponse", ISO_8601_EXTENDED_DATETIME_FORMAT.getPattern(), parse("2022-03-18T09:23:54.00Z"), TimeZone.getTimeZone("UTC")))
        .toPact()
  }

  @Test
  @PactTestFor(pactMethod = "provider")
  void test(MockServer mockServer) {
    TestService testS = new TestService(url: mockServer.getUrl(), restOperations: new RestTemplate())
    TestObject testObject = testS.test()
    assertThat(testObject.lastResponse).isNotNull()
  }
}
