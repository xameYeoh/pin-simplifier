package com.getman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PinSimplifierTest {
    @Test
    public void verifyPin() {
        // given
        PinSimplifier pinSimplifier = new PinSimplifier();
        String[] instructions = new String[]{
                "RUU", "DDDL", "URLLL"
        };

        int expected = 384;
        // when
        int actual = pinSimplifier.pin(instructions);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLongPin() {
        // given
        PinSimplifier pinSimplifier = new PinSimplifier();
        String[] instructions = new String[]{
                "LRLRUUULLLDDUUUUDD"
        };

        int expected = 7;
        // when
        int actual = pinSimplifier.pin(instructions);
        // then
        assertEquals(expected, actual);
    }
}
