public class StringTest {
    public static void main(String[] args) {
        String msg = "The quick brown fox jumps over the lazy dog.";
        System.out.printf("最後に文字 'e' が出現する位置は %d 文字目です。%n", msg.lastIndexOf('e')); // lastIndexOf

        int m = 11;
        int n = 20;
        System.out.printf("文字列の %d 文字目から %d 文字目の部分文字列は %s です。%n", m, n, msg.substring(11, n + 1)); // substring
    }
}