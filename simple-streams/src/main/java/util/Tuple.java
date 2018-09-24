package util;

public final class Tuple<A, B> {
    public final A first;
    public final B second;

    public Tuple(final A first, final B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple) {
            final Tuple<Object, Object> those = (Tuple<Object, Object>) obj;
            return first == those.first && second == those.second;
        } else {
            return false;
        }
    }

    public static <A, B> Tuple<A, B> of (final A a, final B b) {
        return new Tuple<>(a, b);
    }
}
