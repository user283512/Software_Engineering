package App;

import java.util.regex.*;

public class StringCalculator {

  public static int Add(String numbers) {
    // Return 0 for an empty string
    if (numbers == null || numbers.isEmpty())
      return 0;

    String delimiter = "[,\n]";
    String numberPart = numbers;

    if (numbers.startsWith("//")) {
      int delimiterEndIndex = numbers.indexOf("\n");
      if (delimiterEndIndex == -1)
        throw new IllegalArgumentException("Invalid input format: missing newline after custom delimiter.");

      // Extract custom delimiter
      delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
      numberPart = numbers.substring(delimiterEndIndex + 1); // Numbers start after the newline
    }

    // No invalid sequences like ",\n" or "\n,"
    if (numbers.contains(",\n") || numbers.contains("\n,"))
      throw new IllegalArgumentException("Invalid input format: contains invalid delimiter sequence.");

    String[] parts = numberPart.split(delimiter);
    int sum = 0;
    for (String part : parts) {
      int number = Integer.parseInt(part.trim());
      if (number < 0)
        throw new IllegalArgumentException("Negatives not allowed");

      sum += number;
    }

    return sum;
  }
}