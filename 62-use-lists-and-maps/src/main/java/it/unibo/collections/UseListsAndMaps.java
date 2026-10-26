package it.unibo.collections;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 1_000_000;
    private static final int elem1 = 1000;
    private static final int elem2 = 2000;

    private static final int Africa = 1_110_635_000;
    private static final int America = 972_005_000;
    private static final int Antartica = 0;
    private static final int Asia = (int)4_298_723_000L;
    private static final int Europa = 742_452_000;
    private static final int Oceania = 38_304_000;
    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> coll = new ArrayList<>();
        for(int i = elem1; i < elem2; i++){
            coll.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> coll2 = new LinkedList<>(coll);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = (int)coll.get(0);
        coll.set(0, coll.get(coll.size()-1));
        coll.set((coll.size()-1), tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Object o : coll) {
            System.out.println(o);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        
        for (int i = 1; i <= ELEMS; i++) {
            coll.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + ELEMS
                + " element in a List ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        
        for (int i = 1; i <= ELEMS; i++) {
            coll2.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + ELEMS
                + " elements in a List LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        int a = 0;
        time = System.nanoTime();
        for(int i = 0; i <= elem1; i++){
            a = coll.get(coll.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading 1000 times the element in the middle of a List ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for(int i = 0; i <= elem1; i++){
            a = coll2.get(coll2.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading 1000 times the element in the middle of a List LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Integer> map = new HashMap<>();
        map.put("Africa", Africa);
        map.put("Americas", America);
        map.put("Antartica", Antartica);
        map.put("Asia", Asia );
        map.put("Europa", Europa );
        map.put("Oceania", Oceania );


        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for(final Integer i : map.values()){
            worldPopulation = worldPopulation+i; 
        }

        System.out.println("The world population: " + worldPopulation);
    }
}
