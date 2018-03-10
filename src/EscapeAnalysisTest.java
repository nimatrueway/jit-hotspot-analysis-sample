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

        synchronized BigInteger getSum() {
            if (sum == null) {
                sum = IntStream.rangeClosed(1, n).mapToObj(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add);
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
