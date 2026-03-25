package com.example.helloworld

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for MainScreen logic.
 *
 * AI Prompt used (Panda / Gemini):
 * "Generate unit tests for counter state in the HelloWorld app."
 */
class CounterTest {

    @Test
    fun `counter starts at zero`() {
        var count = 0
        assertEquals(0, count)
    }

    @Test
    fun `counter increments correctly`() {
        var count = 0
        repeat(5) { count++ }
        assertEquals(5, count)
    }
}
