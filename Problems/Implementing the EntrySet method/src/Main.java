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
            // put your code here
        }

        public T get(int key) {
            // put your code here          
        }

        public ??? entrySet() {
            // put your code here
        }

        private int findKey(int key) {
            // put your code here
        }

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        // put your code here
    }
}