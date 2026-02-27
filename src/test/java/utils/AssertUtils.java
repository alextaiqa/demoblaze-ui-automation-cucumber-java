package utils;

import static org.testng.Assert.*;

import org.slf4j.Logger;

public class AssertUtils {

    public static void assertEqualsWithLog(String actualResult, String expectedResult, Logger log, String message) {
        log.info("{} | Expected: [{}], Actual: [{}]", message, expectedResult, actualResult);
        assertEquals(actualResult, expectedResult, message);
    }

}
