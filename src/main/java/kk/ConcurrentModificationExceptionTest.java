package kk;

import java.util.*;

public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        List<Integer> ls = new LinkedList<Integer>();
        ls.add(25);
        ls.add(15);
        ls.add(30);
        ls.add(75);
        ls.add(85);
        ls.add(50);
        Collections.sort(ls);
        Iterator itr = ls.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
            if(ls.contains(25)) {
                //ls.remove(new Integer(25));
                itr.remove();
            }
        }
        System.out.println();
        Iterator itr2 = ls.iterator();
        while(itr2.hasNext())
            System.out.print(itr2.next() + " ");
    }
}
