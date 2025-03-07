package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest 
{
  @Test
  public void testAddition() 
  {
    int result = 2 + 3;
    assertEquals(5, result, "2 + 3 should equal 5");
  }

  @Test
  public void testSubtraction() 
  {
    int result = 2 - 3;
    assertEquals(-1, result, "2 - 3 should equal -1");
  }
}