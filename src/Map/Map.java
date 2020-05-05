package Map;

public interface Map<K, V> {
    boolean isEmpty();

    int getSize();

    void add(K key, V value);

    V remove(K key);

    V get(K key);

    boolean contains(K key);

    void set(K key, V value);
}
