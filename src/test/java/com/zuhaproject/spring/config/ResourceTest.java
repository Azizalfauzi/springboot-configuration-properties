package com.zuhaproject.spring.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {
    @Test
    void testResource() throws IOException {
        var resourcec = new ClassPathResource("/text/sample.txt");
        Assertions.assertNotNull(resourcec);
        Assertions.assertTrue(resourcec.exists());
        Assertions.assertNotNull(resourcec.getFile());
    }
}
