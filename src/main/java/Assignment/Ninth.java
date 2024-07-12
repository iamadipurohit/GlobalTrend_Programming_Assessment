package Assignment;

import java.util.*;

public class Ninth {
    // Class to represent intervals
   static class Interval {
        int first, second;

        public Interval(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Class representing the Interval Tree
   static class IntervalTree {
        TreeSet<Interval> treeSet;

        // Constructor for IntervalTree class
        public IntervalTree() {
            // Use a TreeSet with a custom comparator based on the second endpoint of intervals
            treeSet = new TreeSet<>(Comparator.comparingInt(interval -> interval.second));
        }

        // Method to insert an interval into the tree
        public void insert(Interval interval) {
            treeSet.add(interval);
        }

        // Method to search for any interval that overlaps with the given interval
        public Interval overlapSearch(Interval interval) {
            for (Interval i : treeSet) {
                if (doOverlap(interval, i)) {
                    return new Interval(i.first, i.second);
                }
            }
            return NO_INTERVAL_FOUND;
        }

        // Method to remove an interval from the tree
        public void erase(Interval interval) {
            treeSet.remove(interval);
        }

        // Helper method to check if two intervals overlap
        private boolean doOverlap(Interval i1, Interval i2) {
            return (i1.first <= i2.second && i2.first <= i1.second);
        }

        // Declare NO_INTERVAL_FOUND as static or public
        public static final Interval NO_INTERVAL_FOUND = new Interval(1, 0);
    }

        public static void main(String[] args) {
            IntervalTree IT = new IntervalTree();
            Interval[] intvs = {
                    new Interval(15, 20),
                    new Interval(10, 30),
                    new Interval(17, 19),
                    new Interval(5, 20),
                    new Interval(12, 15),
                    new Interval(30, 40)
            };

            // Insert intervals into the tree
            for (Interval intv : intvs) {
                IT.insert(intv);
            }

            // Search for overlapping interval
            Interval toSearch = new Interval(25, 29);
            System.out.println("Searching for interval [" + toSearch.first + ", " + toSearch.second + "]");
            Interval res = IT.overlapSearch(toSearch);
            if (res == IntervalTree.NO_INTERVAL_FOUND)
                System.out.println("No Overlapping Interval");
            else
                System.out.println("Overlaps with [" + res.first + ", " + res.second + "]");

            // Remove an interval from the tree
            Interval toErase = new Interval(10, 30);
            IT.erase(toErase);
            System.out.println("Deleting interval [" + toErase.first + ", " + toErase.second + "]");

            // Search for overlapping interval after deletion
            System.out.println("Searching for interval [" + toSearch.first + ", " + toSearch.second + "]");
            res = IT.overlapSearch(toSearch);
            if (res == IntervalTree.NO_INTERVAL_FOUND)
                System.out.println("No Overlapping Interval");
            else
                System.out.println("Overlaps with [" + res.first + ", " + res.second + "]");
        }

}