package pa11;

import java.util.ArrayList;

public class HashSet {
    int capacity; // capacity
    ArrayList<String>[] data;

    /**
     * Constructor for the set
     */
    public HashSet() {
        this.capacity = 17;
        this.data = new ArrayList[capacity];

        for (int i = 0; i < this.capacity; i++) {
            this.data[i] = new ArrayList<>();
        }
        System.out.println("HashSet");
    }

    private int hash(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;
            total += ascii;
        }
        int position = total % capacity;
        return position;
    }

    /**
     * Size of the set
     * @return the number of elements in the set
     */
    public int size() {
        int size = 0;
        for (ArrayList<String> bucket : data) {
            size += bucket.size();
        }
        return size;
    }

    /** 
     * Check if the set is empty
     * @return a boolean indicating whether the set is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Add an element to the set
     * @param s the element to add
     */
    public void add(String s) {
        int position = this.hash(s);
        if (!data[position].contains(s)) {
            data[position].add(s);
            System.out.println("Adding " + s);
        }
    }

    /** 
     * Remove an element from the set
     * @param s the element to remove
     */
    public void remove(String s) {
        int position = this.hash(s);
        if (data[position].remove(s)) {
            System.out.println("Removing " + s);
        }
    }

    /** 
     * Check if the set contains an element
     * @param s the element to check for
     * @return a boolean indicating whether the set contains the element
     */
    public boolean contains(String s) {
        int position = this.hash(s);
        return data[position].contains(s);
    }

    /** 
     * Clears the set
     */
    public void clear() {
        for (int i = 0; i < this.capacity; i++) {
            this.data[i].clear();
        }
        System.out.println("Clear");
    }

    /** 
     * Convert the set to an array
     * @return an array containing all the elements in the set
     */
    public String[] toArray() {
        ArrayList<String> allElements = new ArrayList<>();
        for (ArrayList<String> bucket : data) {
            allElements.addAll(bucket);
        }
        return allElements.toArray(new String[0]);
    }

    /** 
     * Takes the intersection of the current set and the `other` set
     * @param other the set to intersect with
     * @return a new `HashSet` containing the intersection of the current set and the `other` set
     */
    public HashSet intersection(HashSet other) {
        HashSet result = new HashSet();
        for (ArrayList<String> bucket : data) {
            for (String element : bucket) {
                if (other.contains(element)) {
                    result.add(element);
                }
            }
        }
        return result;
    }

    /** 
     * Convert the set to a string
     * @param other the set to union with
     * @return a new `HashSet` containing the union of the current set and the `other` set
     */
    public HashSet union(HashSet other) {
        HashSet result = new HashSet();
        for (ArrayList<String> bucket : data) {
            for (String element : bucket) {
                result.add(element);
            }
        }
        for (ArrayList<String> bucket : other.data) {
            for (String element : bucket) {
                result.add(element);
            }
        }
        return result;
    }

    /** 
     * Takes the difference of the current set and the `other` set 
     * @param other the set to take the difference with
     * @return a new `HashSet` containing the difference of the current set and the `other` set
     */
    public HashSet difference(HashSet other) {
        HashSet result = new HashSet();
        for (ArrayList<String> bucket : data) {
            for (String element : bucket) {
                if (!other.contains(element)) {
                    result.add(element);
                }
            }
        }
        return result;
}

/** 
 * Check if the current set is a subset of the `other` set
 * @param other the set to check for a subset
 * @return a boolean indicating whether the current set is a subset of the `other` set
 */
public boolean subset(HashSet other) {
    for (ArrayList<String> bucket : data) {
        for (String element : bucket) {
            if (!other.contains(element)) {
                return false; // If any element is not in 'other', return false
            }
        }
    }
    return true; // All elements are in 'other'
}

    public static void main() {
        // This is an empty main method.

    }
}
