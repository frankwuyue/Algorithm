package BinarySearchTree;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }


    @Override
    public void add(E e) {
        if (!this.linkedList.contains(e)) {
            this.linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        this.linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return this.linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }
}
