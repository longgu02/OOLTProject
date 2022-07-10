package hust.soict.globalict.core.utils;

public class Pair<U, V> {

    private U predicate;

    private V object;

    public Pair(U predicate, V object) {

        this.predicate = predicate;
        this.object = object;
    }

    public U getPredicate(){
        return predicate;
    }

    public V getObject(){
        return object;
    }
}

