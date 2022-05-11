package edu.htwk.fdit.algdat;

public class Stack {

    /*Stack
        head
         |
         V
        [ ]->[ ]->[ ]
         |
         V
         obj
    */

    private Element head;

    private class Element {

        Element next;
        Object value;

        public Element(Object o) {
            this.value = o;
        }

    }

    public Stack() {
        head = null;
    }

    public void append(Object obj) {
        Element f = new Element(obj);

        if (head == null) {
            head = f;
        } else {
            f.next = head;
            head.next = f;
        }
    }

    public Object pull() {
        return 0;
    }

    public Object peek() {
        return 0;
    }

}