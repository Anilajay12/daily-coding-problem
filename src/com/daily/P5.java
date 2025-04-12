package com.daily;


/**
 * This problem was asked by Jane Street.
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4
 */



class Cons {

    static class Pair {
        Object first;
        Object last;

        public Pair(Object first, Object last) {
            this.first = first;
            this.last = last;
        }
    }

    public static Object car(Pair pair) {
        return pair.first;
    }

    public static Object cdr(Pair pair) {
        return pair.last;
    }

}

public class P5 {
    public static void main(String[] args) {
        Cons.Pair pair = new Cons.Pair(3,4);
        System.out.println(Cons.car(pair));
        System.out.println(Cons.cdr(pair));
    }
}
