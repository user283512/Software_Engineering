package calculator;

public class Calculator {

  public static int Add(String string) throws NumberFormatException {
    // for an empty string it will return 0
    if (string == null || string.isEmpty())
      return 0;

    String delimiter = ",|\n";
    if (string.startsWith("//")) {
      // indices:
      // i=0 -> '/'
      // i=1 -> '/'
      // i=2 -> [delimiter]
      // i=3 -> '/n'

      delimiter = String.valueOf(string.charAt(2));
      string = string.substring(4);
    }

    int sum = 0;
    String[] numbers = string.split(delimiter);
    for (String _num : numbers) {
      sum += Integer.parseInt(_num.strip());
    }

    return sum;
  }

}