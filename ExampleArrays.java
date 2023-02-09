import tester.*;

import java.util.List;
import java.util.ArrayList;

class ExampleArrays {
    // Task 1.1: averageWithoutLowest
    // Your code here
    String output = averageWithoutLowest(new Number[]{new Fraction(1, 10), new Fraction(2, 3), new Fraction(6, 8)}).toText();

    public Number averageWithoutLowest(Number[] array) {
        if (array.length == 0) return new WholeNumber(0);

        Number lowest = array[0];
        if (array.length == 1) return lowest;

        Number sum = new WholeNumber(0);
        for (Number n : array) {
            if (n.compare(lowest) < 0)
                lowest = n;
            sum = sum.add(n);
        }

        sum = sum.add(new Fraction(-lowest.numerator(), lowest.denominator()));

        return new Fraction(sum.numerator(), sum.denominator()*(array.length - 1));
    }

    // Task 1.2: sumPairs
    // Your code here
    public Pair[] sumPairs(Pair[] a, Pair[] b) {
        if (a.length == 0 || b.length == 0) return new Pair[]{};

        Pair[] pairList = new Pair[Math.min(a.length, b.length)];

        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            pairList[i] = new Pair(a[i].first() + b[i].first(), a[i].second() + b[i].second());
        }

        return pairList;
    }

    // Task 1.3: onRegionEdge
    // Your code here
    public Region[] onRegionEdge(Region[] regions, Point p) {
        List<Region> list = new ArrayList<>();

        for (Region region : regions) {
            if (region.onEdge(p))
                list.add(region);
        }

        return list.toArray(new Region[0]);
    }
}

class Pair {
    // Task 1.2: Pair class
    // Your code here
    private int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int first() {
        return a;
    }

    public int second() {
        return b;
    }
}

