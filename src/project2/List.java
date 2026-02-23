package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<E> implements Iterable<E> {
    private E[] objects; //E is the name for the generic type
    private int size;

    public List() {
        this.objects = (E[]) new Object[4];
        size = 0;
    } //new an array type-casted to E with a capacity of 4.

    private int find(E e) {
        for (int i = 0; i < size; i++){
            if (this.objects[i].equals(e)){
                return i;
            }
        }
        return -1;
    } //return -1 if not found

    private void grow() {
        E[] newList = (E[]) new Object[this.objects.length + 4];
        for (int i = 0; i < this.objects.length; i++){
            newList[i] = this.objects[i];
        }
        this.objects = newList;
    } //grow the size of the array by 4

    public boolean contains(E e) {
        return this.find(e) != -1;
    }
    public void add(E e) {
        if (size == objects.length){
            this.grow();
        }
        objects[size] = e;
        size++;
    }
    public void remove(E e) {
        int removeSpot = this.find(e);
        if (removeSpot == -1){ return; }
        for (int i = removeSpot; i < this.objects.length - 1; i++){
            this.objects[i] = this.objects[i+1];
        }
        this.objects[this.objects.length] = null;
        size--;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public Iterator<E> iterator() {
        return new ListIterator<E>();
    } //traversing the list using for each

    public E get(int index) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException();
        }
        return this.objects[index];
    } //return the object at the index

    public void set(int index, E e) {
        if (index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException();
        }
        objects[index] = e;
    } //put object e at the index

    public int indexOf(E e) {
        for (int i = 0; i < size; i++){
            if (this.objects[i].equals(e)){
                return i;
            }
        }
        return -1;
    } //return index of object e, or return -1
    //private inner class for the iterator to work properly

    private class ListIterator<E> implements Iterator<E> {
        int current = 0; //current index when traversing the list (array)

        @Override
        public boolean hasNext(){
            return current < size;
        } //if it’s empty or at the end of the array

        @Override
        public E next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return (E) objects[current++];
        } //return the next object in the list
    }
}
