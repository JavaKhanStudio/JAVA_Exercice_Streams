package sbp.tuple;

public record InternalTuple2<A, B>(A _1, B _2) {
    public static <A, B> InternalTuple2<A, B> of(A a, B b) {
        return new InternalTuple2<>(a, b);
    }
}