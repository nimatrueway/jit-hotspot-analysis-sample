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

    private static void doTheJob() {
        ArrayList<BigInteger> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Sum sum = new Sum(i % 10);
            list.add(sum.getSum());
        }
        System.out.println(list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100_000; i++) {
            doTheJob();
        }
    }

}
