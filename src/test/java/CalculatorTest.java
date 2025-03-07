package test.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest 
{
  @Test
  public void testAddition() 
  {
    int result = 2 + 3;
    assertEquals("2 + 3 should equal 5", 5, result);
  }

  @Test
  public void testSubtraction() 
  {
    int result = 2 - 3;
    assertEquals("2 - 3 should equal -1", -1, result);
  }
}