package de.huehnerlady.demo.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class ProviderPactTestConfiguration {

  @Bean
  MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
    return new MappingJackson2HttpMessageConverter();
  }

  @Bean
  public TestHttpController testHttpController() {
    return new TestHttpController();
  }
}
