import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.IntStream;

class FunctionUtils {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static Supplier<Integer> getInfiniteRange() {
        return IntStream.iterate(0, i -> i + 1).iterator()::next;
    }

}