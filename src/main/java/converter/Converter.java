package converter;

public class Converter {
  public static int stringToInt(String str) throws IllegalArgumentException {
    // Rimuovi spazi iniziali e finali
    str = str.trim();

    // Controlla se la stringa è vuota
    if (str.isEmpty()) {
      throw new IllegalArgumentException("String is empty");
    }

    // Controlla se la stringa contiene solo numeri e un eventuale segno meno
    if (!str.matches("-?\\d+")) {
      throw new IllegalArgumentException("String contains invalid characters");
    }

    // Converte la stringa in un intero
    int value;
    try {
      value = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("String represents a number out of range");
    }

    // Controlla se il valore è nel range [-32768, 32767]
    if (value < -32768 || value > 32767) {
      throw new IllegalArgumentException("Number out of range [-32768, 32767]");
    }

    return value;
  }
}