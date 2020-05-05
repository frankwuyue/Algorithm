package Sort;

import java.util.Arrays;

public class IndexMaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;
    protected Integer[] indexes;
    protected Integer[] reverse;

    public IndexMaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.indexes = new Integer[capacity + 1];
        this.reverse = new Integer[capacity + 1];
        Arrays.fill(this.reverse, 0);
        this.count = 0;
        this.capacity = capacity;
    }

    public IndexMaxHeap(Item[] array) {
        int n = array.length;
        this.data = (Item[]) new Comparable[n + 1];
        this.capacity = n;
        for (int i = 1; i <= n; i++) {
            data[i] = array[i - 1];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    // i start from 0
    public void insert(int i, Item item) {
        if (count + 1 > capacity) {
            throw new IllegalArgumentException("insert failed, need more capacity.");
        }
        if (i + 1 >= 1 && i + 1 <= capacity) {
            throw new IllegalArgumentException("insert failed, need more capacity.");
        }
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;

        count++;
        shiftUp(count);
    }

    public Item extractItem() {
        if (count <= 0) {
            throw new IllegalArgumentException("count is not greater than 0.");
        }
        swap(data, indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return data[indexes[1]];
    }

    public int extractItemIndex() {
        if (count <= 0) {
            throw new IllegalArgumentException("count is not greater than 0.");
        }
        swap(data, indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return indexes[1] - 1;
    }

    public Item getItem(int i) {
        if (!contain(i)) {
            throw new IllegalArgumentException("i is not in this heap.");
        }
        return data[i + 1];
    }

    public void change(int i, Item item) {
        if (!contain(i)) {
            throw new IllegalArgumentException("i is not in this heap.");
        }
        i += 1;
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contain(int i) {
        if (i + 1 >= 1 && i + 1 <= capacity) {
            throw new IllegalArgumentException("need more capacity.");
        }
        return reverse[i + 1] != 0;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k; // swap j and k
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j += 1;
            }

            if (data[indexes[k]].compareTo(data[indexes[j]]) > 0) {
                break;
            }
            swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swap(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k = k / 2;
        }
    }

    private <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
