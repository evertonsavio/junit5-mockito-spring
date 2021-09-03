package dev.evertonsavio.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

public class InlineMockTest {

    @Test
    void InLineMockTest() {
        Map mapMock = Mockito.mock(Map.class);

        Assertions.assertEquals(0, mapMock.size());

    }
}
