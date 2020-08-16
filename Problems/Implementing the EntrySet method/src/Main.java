import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public List<TableEntry<T>> entrySet() {
            List<TableEntry<T>> list = new ArrayList<>();

            for (TableEntry entry : table) {
                if (entry != null) {
                    list.add(entry);
                }
            }

            return list;
        }

        private int findKey(int key) {
            int hash = key % size;

            while (table[hash] != null && table[hash].getKey() != key) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        // put your code here
    }
}