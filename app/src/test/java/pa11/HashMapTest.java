package pa11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    void TestEmptyMap() {
        HashMap map = new HashMap();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    void TestPutAndGet() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        assertEquals("value1", map.get("key1"));
        assertEquals(1, map.size());
    }

    @Test
    void TestUpdateValue() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        String oldValue = map.put("key1", "value2"); // Update value
        assertEquals("value1", oldValue); // Check old value
        assertEquals("value2", map.get("key1")); // Check new value
    }

    @Test
    void TestRemove() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        String removedValue = map.remove("key1");
        assertEquals("value1", removedValue);
        assertNull(map.get("key1")); // Check that the key is removed
        assertEquals(0, map.size()); // Size should be 0
    }

    @Test
    void TestRemoveNonExistentKey() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        String removedValue = map.remove("key2"); // Remove a non-existent key
        assertNull(removedValue); // Should return null
        assertEquals(1, map.size()); // Size should still be 1
    }

    @Test
    void TestKeySet() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String[] keys = map.keySet();
        assertEquals(2, keys.length);
        assertTrue(java.util.Arrays.asList(keys).contains("key1"));
        assertTrue(java.util.Arrays.asList(keys).contains("key2"));
    }

    @Test
    void TestValues() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String[] values = map.values();
        assertEquals(2, values.length);
        assertTrue(java.util.Arrays.asList(values).contains("value1"));
        assertTrue(java.util.Arrays.asList(values).contains("value2"));
    }

    @Test
    void TestSizeAfterMultipleOperations() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.remove("key1");
        assertEquals(1, map.size()); // Size should be 1 after removal
        map.put("key3", "value3");
        assertEquals(2, map.size()); // Size should be 2 after adding another key
    }
}
