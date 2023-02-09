interface Number {
    // Methods from PA4 - DO NOT MODIFY
    int numerator();
    int denominator();
    Number add(Number n);
    Number multiply(Number n);
    double toDouble();
    String toText();

    default int compare(Number a) {
        double c = toDouble() - a.toDouble();
        if (c < 0) {
            return -1;
        } else if (c > 0) {
            return 1;
        } else {
            return 1;
        }
    }
}

class WholeNumber implements Number {
    int n;

    public WholeNumber(int n) {
        this.n = n;
    }

    public int numerator() {
        return n;
    }

    public int denominator() {
        return 1;
    }

    public Number add(Number other) {
        Number fraction = new Fraction(denominator()*other.numerator() + other.denominator()*numerator(), denominator()*other.denominator());

        return fraction.denominator() == 1 ? new WholeNumber(fraction.numerator()) : fraction;
    }

    public Number multiply(Number other) {
        Number fraction = new Fraction(numerator()*other.numerator(), denominator()*other.denominator());

        return fraction.denominator() == 1 ? new WholeNumber(fraction.numerator()) : fraction;
    }

    public String toText() {
        return String.valueOf(n);
    }

    public double toDouble() {
        return n;
    }
}

class Fraction implements Number {
    int n;
    int d;

    public Fraction(int n, int d) {
        int a = Math.max(n, d);
        int b = Math.min(n, d);

        while (a != 0) {
            int t = b;
            b = a;
            a = t % a;
        }

        this.n = n/b;
        this.d = d/b;
    }

    public int numerator() {
        return n;
    }

    public int denominator() {
        return d;
    }

    public Number add(Number other) {
        Number fraction = new Fraction(denominator()*other.numerator() + other.denominator()*numerator(), denominator()*other.denominator());

        return fraction.denominator() == 1 ? new WholeNumber(fraction.numerator()) : fraction;
    }

    public Number multiply(Number other) {
        Number fraction = new Fraction(numerator()*other.numerator(), denominator()*other.denominator());

        return fraction.denominator() == 1 ? new WholeNumber(fraction.numerator()) : fraction;
    }

    public String toText() {
        return n + "/" + d;
    }

    public double toDouble() {
        return (double)n/(double)d;
    }
}