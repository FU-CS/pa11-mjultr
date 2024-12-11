package pa11;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    private int capacity; // capacity
    private List<Entry>[] table; // Array of lists to handle collisions

    // Inner class to represent a key-value pair
    private class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructor for the map
     */
    public HashMap() {
        this.capacity = 17;
        this.table = new ArrayList[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    /** 
     * Size of the map
     * @return the number of elements in the map
     */
    public int size() {
        int size = 0;
        for (List<Entry> bucket : table) {
            size += bucket.size();
        }
        return size;
    }

    /**
     * Check if the map is empty
     * @return a boolean indicating whether the map is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Get the value associated with the key
     * @param key the key to get the value for
     * @return the value associated with the key, or null if no such entry exists
     */
    public String get(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    /**
     * Add an entry to the map
     * @param key the key to add
     * @param value the value to add
     * @return the old value associated with the key, or null if no such entry exists
     */
    public String put(String key, String value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                String oldValue = entry.value;
                entry.value = value; // Update the value
                return oldValue; // Return the old value
            }
        }
        // If key does not exist, add a new entry
        table[index].add(new Entry(key, value));
        return null; // No old value
    }

    /**
     * Remove an entry from the map
     * @param key the key to remove
     * @return the value associated with the key, or null if no such entry exists
     */
    public String remove(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                String value = entry.value;
                table[index].remove(entry); // Remove the entry
                return value; // Return the removed value
            }
        }
        return null; // Key not found
    }

    /**
     * Get all the keys in the map
     * @return all the keys stored in the map
     */
    public String[] keySet() {
        List<String> keys = new ArrayList<>();
        for (List<Entry> bucket : table) {
            for (Entry entry : bucket) {
                keys.add(entry.key);
            }
        }
        return keys.toArray(new String[0]);
    }

    /**
     * Get all the values in the map
     * @return all the values stored in the map
     */
    public String[] values() {
        List<String> values = new ArrayList<>();
        for (List<Entry> bucket : table) {
            for (Entry entry : bucket) {
                values.add(entry.value);
            }
        }
        return values.toArray(new String[0]);
    }

    /**
     * Hash function to determine the index for a given key
     * @param key the key to hash
     * @return the index in the table
     */
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
