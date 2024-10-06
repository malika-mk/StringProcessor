import org.example.StringProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringProcessorTest {

    @Test
    void isStrongPassword(){
        StringProcessor stringProcessor = new StringProcessor();
        assertTrue(stringProcessor.isStrongPassword("Password123!"));
        assertFalse(stringProcessor.isStrongPassword("weakpass!"));
        assertTrue(stringProcessor.isStrongPassword("Str0ng!"));
        assertFalse(stringProcessor.isStrongPassword("malika!"));
        assertTrue(stringProcessor.isStrongPassword("MMkadsdf123$!"));

    }

    @Test
    void calculateDigits(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(4, stringProcessor.calculateDigits("Hello_2024!"));
        assertEquals(0, stringProcessor.calculateDigits("No digits here!"));
        assertEquals(3, stringProcessor.calculateDigits("123 Main St."));
        assertEquals(4, stringProcessor.calculateDigits("6000 y.o."));
    }

    @Test
    void calculateWords(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(1, stringProcessor.calculateWords("Hello"));
        assertEquals(4, stringProcessor.calculateWords("  This is a sentence.  "));
        assertEquals(0, stringProcessor.calculateWords(""));
        assertEquals(1, stringProcessor.calculateWords("OneWord"));
        assertEquals(2, stringProcessor.calculateWords("   Multiple    spaces  "));

    }

    @Test
    void calculateExpression(){
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(22.0, stringProcessor.calculateExpression("10 + 2 * 6"));
        assertEquals(1400.0, stringProcessor.calculateExpression("100 * ( 2 + 12 )"));
        assertEquals(100.0, stringProcessor.calculateExpression("100 * ( 2 + 12 ) / 14"));
        assertEquals(16.0, stringProcessor.calculateExpression("(5 + 3) * 2"));
        assertEquals(11.0, stringProcessor.calculateExpression("1 + 2 * 5"));
    }

}




