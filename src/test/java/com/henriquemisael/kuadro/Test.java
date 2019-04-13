package com.henriquemisael.kuadro;

import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.format;
import static org.junit.Assert.fail;

public class Test {

    @Autowired
    protected TestSupport testSupport;

    protected void assertThrows(Class<? extends Throwable> expected, Executable executable) {
        try {
            executable.execute();
        } catch (Throwable actualThrowable) {
            if (expected.isInstance(actualThrowable)) {
                return;
            }
            fail(format(null, expected, actualThrowable));
        }
        fail("Expected to throw: " + expected);
    }

    public interface Executable {

        void execute() throws Throwable;
    }
}
