import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyNil<A> implements MyList<A> {
    public MyNil(){
    }

    @Override
    public int length(){
        return 0;
    }

    @Override
    public Optional<A> find(Predicate<A> p) {
        return Optional.empty();
    }

    @Override
    public Optional<A> get(int index) {
        return Optional.empty();
    }

    @Override
    public MyList<A> prepend(A a) {
        return new MyConst<>(a, this);
    }

    @Override
    public MyList<A> append(A a) {
        return new MyConst<>(a, new MyNil<>());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MyNil;
    }

    @Override
    public MyList<A> concat(MyList<A> list) {
        return list;
    }

    @Override
    public <B> MyList<B> map(Function<A, B> f) {
        return new MyNil<>();
    }

    @Override
    public void foreach(Consumer<A> f) {
        return;
    }

    @Override
    public <B> MyList<B> flatMap(Function<A, MyList<B>> f) {
        return new MyNil<>();
    }

    @Override
    public <B> B fold(B initial, BiFunction<A, B, B> merge) {
        return initial;
    }

    @Override
    public String join(String seperator) {
        return "";
    }

    @Override
    public String join(String prefix, String seperator, String postfix) {
        return prefix + postfix;
    }

    @Override
    public String toString() {
        return "MyList()";
    }
}
