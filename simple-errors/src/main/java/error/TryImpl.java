package error;

import java.util.function.Supplier;

public class TryImpl {

    // FUNCTIONAL PROGRAMMING FORUM

    public interface Try<A> {}

    public static final class Success<A> implements Try<A> {
        public final A result;

        public Success(final A result) {
            this.result = result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Success) {
                final Success<Object> that = (Success<Object>) obj;
                return result.equals(that.result);
            }
            else return false;
        }
    }


    public static final class Failure<A> implements  Try<A> {
        public final Throwable error;

        public Failure(final Throwable err) {
            this.error = err;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Failure) {
                final Failure<Object> that = (Failure<Object>) obj;
                return error.equals(that.error);
            }
            else return false;
        }
    }

    public static <A> Try<A> attempt (final Supplier<A> f) {
        try { return new Success<>(f.get()); }
        catch (Exception e) { return new Failure<>(e); }
    }
}
