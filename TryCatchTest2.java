public class TryCatchTest2 {
    public static void main(String[] args) {
      int i, m = 1;
      try { 
        for (i = 0; i < args.length; i++) {
          m *= foo(args[i]);
        }
      } catch (Exception e) {
        m = 0;
      }
      System.out.println("答は " + m + " です。");
    }
  
    public static int foo(String arg) throws Exception {
      int a = Integer.parseInt(arg);
      if (a == 0) throw new Exception("zero");
      return a;
    }
  }