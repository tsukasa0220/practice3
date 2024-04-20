public class TryCatchTest {
    public static void main(String[] args) {
      int i;
      for (i = -3; i <= 3; i++) {
        try { 
          System.out.printf("10 / %d = %d%n",
                            i, 10 / i);
        } catch (ArithmeticException e) {
          System.out.println("エラー: " + e.toString());
        }
      }
      System.out.println("終");
    }
  }