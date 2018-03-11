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
            Sum sum = new Sum(i);
            list.add(sum.getSum());
        }
        System.out.println(list.get(list.size() - 1));
    }

}
