package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void testSimpleAdd() {
    assertEquals(
        Calculator.Add(null),
        0);

    assertEquals(
        Calculator.Add(""),
        0);

    assertEquals(
        Calculator.Add("10"),
        10);

    assertEquals(
        Calculator.Add("10,20"),
        30);
  }

  @Test
  public void testAddMultipleNumbers() {
    assertEquals(
        Calculator.Add("1,\n"),
        1);

    assertEquals(
        Calculator.Add("1,3,7"),
        11);

    assertEquals(
        Calculator.Add("1,3,7,9,10"),
        30);

    assertEquals(
        Calculator.Add("1\n3,7\n9,10"),
        30);
  }

  @Test
  public void testAddWithCustomDelimiters() {
    assertEquals(
        Calculator.Add("//;\n1;2;3;4;5"),
        15);

    assertEquals(
        Calculator.Add("//,\n1,2,3,4,5"),
        15);

    assertEquals(
        Calculator.Add("//\n\n1\n2\n3\n4\n5"),
        15);

    assertEquals(
        Calculator.Add("//q\n1q2q3q4q5"),
        15);
  }

}