import java.util.Arrays;

//second version of ArrayIntList to store a list of ints
public class ArrayIntList {

    //instance var
    private int[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 100;

    //constructor
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayIntList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    //return the current number of elements in the list
    public int size() {
        return size;
    }

    //pre: 0 <= index < size
    //post: return the integer value at the given index in the lsit
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    //throw an exception if index is not legal for current list
    private void checkIndex(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    //return position of first occurrence of the value
    public int indexOf(int value) {
        for(int i = 0; i < size; i++) {
            if(elementData[i] == value) {
                return i;
            }
        }

        return -1;
    }

    //return true if list is empty
    public boolean isEmpty() {
        return size == 0; //return true if size is 0
    }

    //return true if a value is in the list
    public boolean contains(int value) {
        return indexOf(value) >= 0; //
    }

    //append a value to the end of a list
    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    //append a value to the end of a list
    public void add(int index, int value) {
        checkIndex(index);
        ensureCapacity(size + 1);
        for(int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        size++;
    }

    //ensure that array is given capacity or double the size
    public void ensureCapacity(int capacity) {
        if(capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if(capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    //removing an element from an index
    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
    }

    //replace an int at a given index with a new value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    //the list is empty
    public void clear() {
        size = 0;
    }

    //append all values in the list to the end of this list
    public void addAll(ArrayIntList other) {
        ensureCapacity(size + other.size());
        for(int i = 0; i < other.size(); i++) {
            add(i, other.elementData[i]);
        }
    }

    public ArrayListIterator iterator() {
        return new ArrayListIterator(this);
    }

    public String toString() {
        if(size == 0) {
            return "[]";
        }else {
            //fence post
            String result = "[";
            for(int i = 1; i < elementData.length; i++) {
                result += elementData[i] + ", ";
            }
            result += "]";
            return result;
        }
    }

    //create a method that loops through the list
    //updating the index of each occurrence of the given value
    //otherwise print out -1
    public void lastIndexOf(int value){
        int current = -1;
        for (int i = 0; i < elementData.length - 1; i++){
            if(value == elementData[i]){
                current = i;
            }

        }

        if(current == -1){
            System.out.println(current);
        } else {
            System.out.println("The last index of " + value + " is " + current);
        }

    }

    //create a method that replaces every occurrence of a given value
    //with the new given value
    public void replaceAll(int toBeReplaced, int replacementValue){
        for (int i = 0; i < elementData.length - 1; i++){
            if (elementData[i] == toBeReplaced){
                elementData[i] = replacementValue;
            }
        }
    }
}

