package com.interviewBitScaler.heap.application;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestPrimeFactor {

    public static void main(String[] args) {
        int[] a = new int[]{1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297};
        int b = 42;
        int out[] = solve(a, b);
        System.out.println(out[0]);
        System.out.println(out[1]);
    }


    public static int[] solve(int[] A, int B) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> A[p1[0]] * A[p2[1]] - A[p2[0]] * A[p1[1]]
        );

        Set<int[]> set = new TreeSet<>(
                (o1, o2) -> {
                    if (o1[0] < o2[0] || o1[1] < o2[1]) {
                        return -1;
                    } else if (o1[0] > o2[0] || o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
        );

        int i = 0;
        int j = A.length - 1;

        set.add(new int[]{i, j});
        pq.add(new int[]{i, j});

        int[] temp = null;
        while (B > 0) {
            temp = pq.poll();

            int[] l = new int[]{temp[0] + 1, temp[1]};
            int[] r = new int[]{temp[0], temp[1] - 1};
            if (!set.contains(l)) {
                pq.add(l);
                set.add(l);
            }
            if (!set.contains(r)) {
                pq.add(r);
                set.add(r);
            }
            B--;
        }
        return new int[]{A[temp[0]], A[temp[1]]};
    }
//
//    public static int[] solve(int[] A, int B) {
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>(
//                (p1, p2) -> A[p1.nri] * A[p2.dri] - A[p2.nri] * A[p1.dri]
//        );
//        Set<Pair> set = new HashSet<>();
//
//        int i = 0;
//        int j = A.length - 1;
//
//        set.add(new Pair(i, j));
//        pq.add(new Pair(i, j));
//
//        Pair temp = null;
//        while (B > 0) {
//            temp = pq.poll();
//
//            Pair l = new Pair(temp.nri + 1, temp.dri);
//            Pair r = new Pair(temp.nri, temp.dri - 1);
//            if (!set.contains(l)) {
//                pq.add(l);
//                set.add(l);
//            }
//            if (!set.contains(r)) {
//                pq.add(r);
//                set.add(r);
//            }
//            B--;
//        }
//        return new int[]{A[temp.nri], A[temp.dri]};
//    }
}

class Pair {
    int nri;
    int dri;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return nri == pair.nri &&
                dri == pair.dri;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nri, dri);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "nri=" + nri +
                ", dri=" + dri +
                '}';
    }

    Pair(int nri, int dri) {
        this.nri = nri;
        this.dri = dri;
    }

}