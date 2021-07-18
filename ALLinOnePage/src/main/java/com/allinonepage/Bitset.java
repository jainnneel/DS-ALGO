package com.allinonepage;

import java.util.BitSet;

public class Bitset {

    public static void main(String[] args) {
        BitSet s1 = new BitSet(5);
        BitSet s2 = new BitSet(5);
        
        s1.and(s2);
        System.out.println(s1.cardinality()+" "+s2.cardinality());
        s1.set(4,true);
        System.out.println(s1.cardinality()+" "+s2.cardinality());
        s2.flip(2);
        System.out.println(s1.cardinality()+" "+s2.cardinality());
        s2.or(s1);
        System.out.println(s1.cardinality()+" "+s2.cardinality());
    }
}
