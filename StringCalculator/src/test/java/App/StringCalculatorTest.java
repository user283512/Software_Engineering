package App;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class StringCalculatorTest {

	@Test
	public void testAdd() throws IllegalArgumentException {
		assertEquals(StringCalculator.Add(""), 0);
		assertEquals(StringCalculator.Add(null), 0);
		assertEquals(StringCalculator.Add("1,2"), 3);
		assertEquals(StringCalculator.Add("1\n2"), 3);
		assertEquals(StringCalculator.Add("1\n2,3"), 6);

		assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.Add("1,2\n,3");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.Add("1\n,2,3");
		});

		assertEquals(StringCalculator.Add("//;\n1;2"), 3); // Custom delimiter ";"
		assertEquals(StringCalculator.Add("//|\n4|5|6"), 15); // Custom delimiter "|"
		assertEquals(StringCalculator.Add("//***\n7***8***9"), 24); // Custom delimiter "***"

		assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.Add("1,-2,3,-4");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.Add("//;\n1;-2;-3");
		});
	}

}
