package com.example.altr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AltrApplicationTest {

    @Test
    @DisplayName("Test 2 + 2 = 4")
    void testTest() throws Exception {
        System.out.println("TESTTTTTTTTTTTTTTTTTTTT");
        Assertions.assertEquals(4, 2 + 2);
    }

}
