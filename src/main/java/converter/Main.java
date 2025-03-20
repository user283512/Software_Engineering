package converter;

public class Main {
  public static void main(String[] args) {
    // Esempi di utilizzo
    try {
      System.out.println(Converter.stringToInt(" -3")); // Output: -3
      System.out.println(Converter.stringToInt("500")); // Output: 500
      System.out.println(Converter.stringToInt("-10")); // Output: -10
      System.out.println(Converter.stringToInt("32767")); // Output: 32767
      System.out.println(Converter.stringToInt("32768")); // Eccezione: Number out of range
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }
}