package com.raca.wheateradvice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WheaterUtilsTest {

    @Test
    void weatherAdvice_cancel() {
        assertEquals("CANCEL", WheaterUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    void weatherAdvice_warn() {
        assertEquals("WARN", WheaterUtils.weatherAdvice(62.0, 0.0));
    }

    @Test
    void weatherAdvice_allclear() {
        assertEquals("ALL CLEAR", WheaterUtils.weatherAdvice(30.0, 2.0));
    }

    @Test
    void weatherAdvice_negativeWindSpeed() {
        assertThrows(IllegalArgumentException.class, () -> WheaterUtils.weatherAdvice(-1.0, 0.0));
    }






}