package com.henriquemisael.kuadro;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
@RunWith(SpringRunner.class)
public abstract class UnitTest {

    @Before
    public void before() {
        initMocks(this);
    }
}
