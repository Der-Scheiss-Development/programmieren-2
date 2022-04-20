package edu.htwk.fdit.prog2.uebung2;

public class List {
    public Element head = null;
    private Object data;

    private class Element { // inner private class

        private Object data;
        private Element next;
        public Element(Object data) {
            this.data = data;
            this.next = null;
        }

    }

    // constructs list from varargs
    public List(Object ... objs) {
        Element current = head;
            for (Object o: objs) {
                System.out.println("Creating new list and appending " + o + " to list");
                if (current == null) {
                    this.head = new Element(o);
                } else {
                    while (current.next != null) {
                        current = current.next;
                    }
                        current.next = new Element(o);
                }
            }
    }

    // how many items in the list
    public int size() {
        Element current = head;
        int i = 0;
        while (current.next != null) {
            current = current.next;
            ++i;
        }
        return i;
    }

    // returns element at index
    public Object get(int index) {
        if (index > size()) {
            System.out.println("An element at the index you've given does not exist.");
            return null;
        } else {
            Element current = head;

            for (int i = 0; i <= index; ++i) {

                current = current.next;
            }
            return current;
        }
    }

    // inserts Object o at index
    public void insert(Object o, int index) {
        // Create a new node
        Element newNode = new Element(o);

        // Init the cur and prev nodes to the head
        Element current = this.head, prev = this.head;

        if (index == 1) {
            // Point the new node's next to head
            newNode.next = head;
            // Make the new node as head
            this.head = newNode;
            return;
        }

        // get to the end of the list and check positions moved
        while (current.next != null && --index > 0) {
            // update the prev and cur references
            prev = current;
            current = current.next;
        }

        // update prev to point to new node
        prev.next = newNode;

        // & new node to point to current node
        newNode.next = current;
    }

    // returns first index where the object equals o
    public int findFirst(Object o) {
        Element current = head;
        if (current != null) {
            int i = 0;
            while (current != o && current.next != null) {
                current = current.next;
                ++i;
            }
            return i;
        } else {
            return -1;
        }
    }

    // Magic to convert HashCode to a String
    public String toString() {                                          //Anm.: macht nicht das, was es machen soll :/
        String hash = String.valueOf(System.identityHashCode(data));
        String className = this.data.getClass().getSimpleName();
        return className + "(" + data + ")@" + hash;
    }

    // gives last element of the list
    public Object last() {
        Element current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    // appends element at the end of list
    public void append(Object o) {
        System.out.println("Appending element " + o + " to list");
        Element current = this.head;
        if (current == null) {
             this.head = new Element(o);
        } else {
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Element(o);
        }
    }

    // deletes element at index, returns if out of range
    public void delete(int index) {
        if (index > size()) {
            System.out.println("The list does not have an element at this position!");
        } else {
            if (head == null) {
                System.out.println("The list does not exist :O");
                return;

            }
            System.out.println("Deleting element at index " + index);
            Element temp = head;

            // remove head
            if (index == 0) {
                head = temp.next; // Change head
                return;
            }

            // Find previous node of the node to be deleted
            for (int i = 0; temp != null && i < index - 1; i++) {
                temp = temp.next;
            }

            // If position is more than number of nodes
            if (temp == null || temp.next == null)
                return;

            // Node temp->next is the node to be deleted
            // Store pointer to the next of node to be deleted
            Element next = temp.next.next;

            temp.next = next; // Unlink the deleted node from list
        }
    }

    //print list
    public void print() {
        Element tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    //main method
    public static void main(String[] args) {
        List list = new List();
        System.out.println("Created a singly linked list");
        list.append(100);
        list.append(200);
        list.print();

        System.out.println(list.size()); //prints size of list, counted from zero
        //list.delete(3);
        list.print();

        list.insert(111,1); // DOES NOT COUNT FROM ZERO!
        list.print();

        System.out.println(list.size()); //prints size of list, counted from zero

        list.delete(1); //delete at index, counts from zero :)
        list.print();

        System.out.println(list.findFirst(200));
        System.out.println(list.get(1));

        System.out.println(new List(1,2,3,4,5));


    }
}