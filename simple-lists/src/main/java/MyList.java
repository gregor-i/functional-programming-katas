import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface MyList<A> {
    public int length();

    public Optional<A> find(Predicate<A> p);

    public Optional<A> get(int index);

    public MyList<A> prepend(A a);

    public MyList<A> append(A a);

    public MyList<A> concat(MyList<A> list);

    public <B> MyList<B> map(Function<A, B> f);

<<<<<<< HEAD
=======
    public MyList<A> filter(Predicate<A> f);

>>>>>>> d9f221aef90fcb2267aae087e2df6dace5da4ca7
    public void foreach(Consumer<A> f);

    public <B> MyList<B> flatMap(Function<A, MyList<B>> f);

    public <B> B fold(B initial, BiFunction<A, B, B> merge);

    public String join(String seperator);

    public String join(String prefix, String seperator, String postfix);

    @SafeVarargs
    static <A> MyList<A> construct(A... args){
        MyList<A> acc = new MyNil<>();
        for(int i=args.length-1; i >= 0; i--)
            acc = new MyConst<>(args[i], acc);
        return acc;
    }
}
