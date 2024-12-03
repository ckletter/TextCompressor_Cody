import java.util.ArrayList;
import java.util.Arrays;

public class HashMap {
    // Instance variables for default table size, table size, elements,
    // radix, load factor, parallel arrays for keys and values
    public static final int DEFAULT_TABLE_SIZE = 10937;
    public static final int RADIX = 256;
    public static final double LOAD_FACTOR = 0.5;
    private int tableSize;
    private int elements;
    private String[] keys;
    private int[] values;

    /**
     * Constructor - initializes hash map for keys and values to default table size
     */
    public HashMap() {
        this.tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[this.tableSize];
        this.values = new int[this.tableSize];
    }

    /**
     * Hashes a given key according to our default table size as our P value
     * Uses horner's method
     * @param key
     * @return hashed key from 0 to default table size - 1
     */
    public int hash(String key) {
        int length = key.length();
        int hash = 0;
        // Loops through each character and hashes it by horner's method
        for (int i = 0; i < length; i++) {
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    /**
     * Adds a new key and value to our hash map using linear probing
     * If at hashed location, element already exists, keeps increasing index until empty space is reached
     * If by adding the element, we exceed our load factor, then we resize the hash map
     * @param key
     */
    public void add(String key) {
        elements = elements + 1;
        // Calculate alpha (how full our table is)
        double alpha = (double) (elements) / tableSize;
        // If alpha exceeds our load factor (0.5), then resize the entire table
        if (alpha > LOAD_FACTOR) {
            resize();
        }
        // Go to index of hashed key
        int currentIndex = hash(key);
        // Keep increasing our index by one until we reach an empty space, then add in that location
        while (!(keys[currentIndex].equals(key)) || keys[currentIndex] != null) {
            currentIndex = (currentIndex + 1) % tableSize;
        }
        if (keys[currentIndex].equals(key)) {
            values[currentIndex] = values[currentIndex] + 1;
        } else {
            // Set key and value to index of closest open space
            keys[currentIndex] = key;
            values[currentIndex] = 1;
        }
    }
//
//    /**
//     * Given a key, returns the key's value in our hashmap by using linear probing
//     * If the key does not exist, returns "INVALID KEY"
//     *
//     * @param key
//     * @return key's value if exists, otherwise "INVALID KEY"
//     */
//    public int get(String key) {
//        int currentIndex = hash(key);
//        boolean keyNotFound = true;
//        // Keeps looping until we find our key or empty space is reached
//        while (keyNotFound) {
//            // If we reach an empty space, return that key does not exist
//            if (keys[currentIndex] == null) {
//                return "INVALID KEY";
//            }
//            // If our current location is where our key exists, returns the key's value
//            else if (keys[currentIndex].equals(key)) {
//                return values[currentIndex];
//            }
//            // Increasing our index by one to search next closest neighbor to key's hashed index
//            currentIndex = (currentIndex + 1) % tableSize;
//        }
//        return "ERROR";
//    }

    /**
     * Resizes our table whenever our load factor is reached, multiplying our table by 2
     * Also, re-hashes each individual element in our hashmap so that it is properly retrieved when searching
     */
    public void resize() {
        int length = tableSize;
        // Double our table size and create new key and value arrays of doubled size
        tableSize = tableSize * 2;
        String[] newKeys = new String[tableSize];
        int[] newVals = new int[tableSize];
        // Loop through each index in our old keys array
        for (int i = 0; i < length; i++) {
            // If no element exists in current location, go to the next index
            if (keys[i] == null) {
                continue;
            }
            // If element exists, rehash the element's key with our new table size
            int currentIndex = hash(keys[i]);
            // Determines proper index to place the element in our new array (first open space, via linear probing)
            while (newKeys[currentIndex] != null) {
                currentIndex = (currentIndex + 1) % tableSize;
            }
            // Adds element's key and value to our new key and new value array in proper location
            newKeys[currentIndex] = keys[i];
            newVals[currentIndex] = values[i];
        }
        // Updates our key and value arrays to our new doubled table size
        this.keys = newKeys;
        this.values = newVals;
    }
    public String[] getRepeats() {
        ArrayList<String> keyList = new ArrayList<String>();
        keyList = (ArrayList<String>) Arrays.asList(keys);
        ArrayList<Integer> valList = new ArrayList<Integer>();
        valList = (ArrayList<Integer>) Arrays.asList(keys);
        list.removeIf(String::isEmpty);
    }
}
