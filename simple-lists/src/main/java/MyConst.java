import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyConst<A> implements MyList<A> {
    public final A head;
    public final MyList<A> tail;

    public MyConst(A head, MyList<A> tail){
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int length() {
        return 1 + tail.length();
    }

    @Override
    public Optional<A> find(Predicate<A> p) {
        if(p.test(head))
            return Optional.of(head);
        else
            return tail.find(p);
    }

    @Override
    public Optional<A> get(int index) {
        if(index == 0)
            return Optional.of(head);
        else
            return tail.get(index-1);
    }

    @Override
    public MyList<A> prepend(A a) {
        return new MyConst<>(a, this);
    }

    @Override
    public MyList<A> append(A a) {
        return new MyConst<>(head, tail.append(a));
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof MyConst) {
            MyConst<?> other = (MyConst<?>) o;
            return other.head.equals(this.head) && other.tail.equals(this.tail);
        }else{
            return false;
        }
    }

    @Override
    public MyList<A> concat(MyList<A> list) {
        return new MyConst<>(head, tail.concat(list));
    }

    @Override
    public <B> MyList<B> map(Function<A, B> f) {
        return new MyConst<B>(f.apply(head), tail.map(f));
    }

    @Override
    public MyList<A> filter(Predicate<A> f) {
        if (f.test(head))
            return new MyConst<A>(head, tail.filter(f));
        else
            return tail.filter(f);
    }

    @Override
    public void foreach(Consumer<A> f) {
        f.accept(head);
        tail.foreach(f);
    }

    @Override
    public <B> MyList<B> flatMap(Function<A, MyList<B>> f) {
        return f.apply(head).concat(tail.flatMap(f));
    }

    @Override
    public <B> B fold(B initial, BiFunction<A, B, B> merge) {
        return merge.apply(head, tail.fold(initial, merge));
    }

    @Override
    public String join(String seperator) {
        if(tail instanceof MyConst)
            return head.toString() + seperator + tail.join(seperator);
        else
            return head.toString();
    }

    @Override
    public String join(String prefix, String seperator, String postfix) {
        return prefix + join(seperator) + postfix;
    }

    @Override
    public String toString() {
        return join("MyList(", ", ", ")");
    }
}
