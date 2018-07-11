package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class SortByFrequency {
    private static class Data implements Comparable<Data>{
        int num;
        int freq;

        public Data(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "num=" + num +
                    ", freq=" + freq +
                    '}';
        }

        @Override
        public int compareTo(Data d) {
            return freq - d.freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return num == data.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }

    public static void main(String[] args) {
        ArrayList<Data> ls = new ArrayList<Data>();
        int[] arr = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,5,5,5,6,6,3,7,8,9};

        for(int n:arr){
            Data d = new Data(n,1);
            if(ls.contains(d)){
                Data d1 = ls.get(ls.indexOf(d));
                d1.freq++;
            }
            else
                ls.add(d);
        }


        Collections.sort(ls,Collections.<Data>reverseOrder());


        Iterator itr = ls.iterator();
        while (itr.hasNext()){
            Data d = (Data)itr.next();
            for(int i= 0;i<d.freq;i++)
                System.out.print(d.num+",");
        }
    }
}
