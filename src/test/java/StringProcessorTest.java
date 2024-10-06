import org.example.StringProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringProcessorTest {

    @Test
    void isStrongPassword(){
        StringProcessor stringProcessor = new StringProcessor();
        assertTrue(stringProcessor.isStrongPassword("Password123!")); // Output: True
        assertFalse(stringProcessor.isStrongPassword("weakpass!"));// Output: False
        assertTrue(stringProcessor.isStrongPassword("Str0ng!"));// Output: True
        assertFalse(stringProcessor.isStrongPassword("malika!"));// Output: False
        assertTrue(stringProcessor.isStrongPassword("MMkadsdf123$!"));// Output: True

    }

    @Test
    void calculateDigits(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(4, stringProcessor.calculateDigits("Hello_2024!")); // Output: 4
        assertEquals(0, stringProcessor.calculateDigits("No digits here!"));// Output: 0
        assertEquals(3, stringProcessor.calculateDigits("123 Main St."));// Output: 3
        assertEquals(4, stringProcessor.calculateDigits("6000 y.o."));// Output: 4
    }

    @Test
    void calculateWords(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(1, stringProcessor.calculateWords("Hello"));// Output: 1
        assertEquals(4, stringProcessor.calculateWords("  This is a sentence.  "));// Output: 4
        assertEquals(0, stringProcessor.calculateWords(""));// Output: 0
        assertEquals(1, stringProcessor.calculateWords("OneWord"));// Output: 1
        assertEquals(2, stringProcessor.calculateWords("   Multiple    spaces  "));// Output: 2

    }

    @Test
    void calculateExpression(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(22.0, stringProcessor.calculateExpression("10 + 2 * 6"));// Output: 22.0
        assertEquals(1400.0, stringProcessor.calculateExpression("100 * ( 2 + 12 )"));// Output: 1400.0
        assertEquals(100.0, stringProcessor.calculateExpression("100 * ( 2 + 12 ) / 14"));// Output: 100.0
        assertEquals(16.0, stringProcessor.calculateExpression("(5 + 3) * 2"));// Output: 16.0
        assertEquals(11.0, stringProcessor.calculateExpression("1 + 2 * 5"));// Output: 11.0
    }

}




