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

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    rehash();
                    return findKey(key);
                }
            }

            return hash;
        }

        private void rehash() {
            size = size * 2;
            HashTable<T> hTable = new HashTable<>(size);
            for (TableEntry entry : table) {
                hTable.put(entry.getKey(), (T) entry.getValue());
            }
            table = hTable.table;
        }

        public void remove(int key) {
            // put your code here
            for (TableEntry tableEntry : table) {
                if(tableEntry != null && tableEntry.getKey() == key) {
                    tableEntry.remove();
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int insert = scanner.nextInt();
        int remove = scanner.nextInt();

        HashTable<String> hashTable = new HashTable<>(5);

        for (int i = 0; i < insert; i++) {
            hashTable.put(scanner.nextInt(), scanner.next());
        }
        for (int i = 0; i < remove; i++) {
            hashTable.remove(scanner.nextInt());
        }
        System.out.println(hashTable.toString());
    }
}