package calculator;

public class Main {
  public static void main(String[] args) {
    String s = "1";
    String[] split = s.split(",");

    System.out.println(s);
    for (String _s : split) {
      System.out.println(_s);
    }
    System.out.println(split.length);

  }
}