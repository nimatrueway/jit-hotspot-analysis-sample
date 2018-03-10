import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class EscapeAnalysisTest {

    private static class Sum {

        private BigInteger sum;
        private int n;

        Sum(int n) {
            this.n = n;
        }

        synchronized final BigInteger getSum() {
            if (sum == null) {
                sum = BigInteger.ZERO;
                for (int i = 0; i < n; i++) {
                    sum = sum.add(BigInteger.valueOf(i));
                }
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        ArrayList<BigInteger> list = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            list.add(new Sum(i).getSum());
        }
        list.forEach(System.out::println);
    }

}
