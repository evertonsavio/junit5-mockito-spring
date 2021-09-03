package dev.evertonsavio.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

public class AnnotationMockTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock(){
        mapMock.put("keyValue", "foo");
    }

}
