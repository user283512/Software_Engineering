package exercise2.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ConverterTest {

  @Test
  public void testValidConversions() {
    assertEquals(-3, Converter.stringToInt(" -3"));
    assertEquals(500, Converter.stringToInt("500"));
    assertEquals(-10, Converter.stringToInt("-10"));
    assertEquals(32767, Converter.stringToInt("32767"));
  }

  @Test
  public void testInvalidConversions() {
    assertThrows(IllegalArgumentException.class, () -> {
      Converter.stringToInt("2 3");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Converter.stringToInt("32768");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Converter.stringToInt("A3");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Converter.stringToInt("2.3");
    });
  }
}