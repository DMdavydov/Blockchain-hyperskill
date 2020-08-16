import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

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

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
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

        public void get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                System.out.println(-1);
                return;
            }

            System.out.println((T) table[idx].getValue());
        }

        public void remove(int key) {
            int idx = findKey(key);

            table[idx] = null;
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        HashTable<String> hashTable = new HashTable<>(size);
        for (int i = 0; i < hashTable.size; i++) {
            String action = scanner.next();
            switch (action) {
                case "put":
                    hashTable.put(scanner.nextInt(), scanner.next());
                    break;
                case "get":
                    hashTable.get(scanner.nextInt());
                    break;
                case "remove":
                    hashTable.remove(scanner.nextInt());
                    break;
            }
        }
    }
}