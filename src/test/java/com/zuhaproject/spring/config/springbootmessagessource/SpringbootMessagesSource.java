package com.zuhaproject.spring.config.springbootmessagessource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringbootMessagesSource.TestApplication.class)
public class SpringbootMessagesSource {
    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void helloAziz() {
        Assertions.assertEquals("HelloAziz", sampleSource.helloAziz(Locale.ENGLISH));
        Assertions.assertEquals("HaloAziz", sampleSource.helloAziz(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {
        @Component
        public static class SampleSource implements MessageSourceAware {
            @Setter
            private MessageSource messageSource;

            public String helloAziz(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Aziz"}, locale);
            }
        }
    }
}
