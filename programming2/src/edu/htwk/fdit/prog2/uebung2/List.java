package edu.htwk.fdit.prog2.uebung2;

public class List {
    private class Element { // inner private class

        //something's missing
        public String toString() {
            String hash = System.identityHashCode(this.value);
            String className = this.value.getClass().getSimpleName();
            return className + "(" + value + ")@" + hash;
        }
    }

    public List(Object ... objs) {

    } // constructs list from varargs

    public int size() {

    } // how many items in the list

    public Object get(int index) {

    } // returns element a index

    public void insert(Object o, int index) {

    } // inserts Object o at index

    public int findFirst(Object o) {

    } // returns first index where the object equals o

    public String toString() {

    } // renders list into string bounded by [] and seperated by ,

    public Object last() {

    } // gives last element of the list

    public void append(Object o) {

    } // appends element at the end of list

    public void delete(int index) {

    } // deletes element at index, returns if out of range

    public static void main(String[] args) {

    }

}