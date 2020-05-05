package Map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedListMap() {
        dummyHead = new Node(null, null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // if contains key, overwrite value
    @Override
    public void add(K key, V value) {
        Node node = this.getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = this.getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist.");
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null) {
            Node node = cur.next;
            cur.next = node.next;
            node.next = null;
            size--;
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return this.getNode(k) != null;
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
