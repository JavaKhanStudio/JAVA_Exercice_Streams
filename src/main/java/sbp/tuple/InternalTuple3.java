package sbp.tuple;

public record InternalTuple3<A, B, C>(A _1, B _2, C _3) {
    public static <A, B, C> InternalTuple3<A, B, C> of(A a, B b, C c) {
        return new InternalTuple3<>(a, b, c);
    }
}