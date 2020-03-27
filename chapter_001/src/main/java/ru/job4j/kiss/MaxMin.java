package ru.job4j.kiss;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return minMax(x -> x > 0, value, comparator);
    }
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return minMax(x -> x < 0, value, comparator);
    }

    private <T> T minMax(Predicate<Integer> predicate, List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            int compareResult = comparator.compare(value.get(i), result);
            if (predicate.test(compareResult)) {
                result = value.get(i);
            }
        }
        return result;
    }

}