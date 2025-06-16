package com.example;
import java.util.List;
import java.util.ArrayList;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>>[] table;
    private int size;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
        this.size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i].clear();
        }
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int insert(K key, V value) {
        int comparisons = 0;
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            comparisons++;
            if (entry.key.equals(key)) {
                entry.value = value;
                return comparisons;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
        return comparisons + 1;
    }

    public int search(K key) {
        int comparisons = 0;
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            comparisons++;
            if (entry.key.equals(key)) {
                return comparisons;
            }
        }
        return comparisons;
    }
}
