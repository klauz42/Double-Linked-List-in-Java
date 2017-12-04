public class DLLTest {
    public static void main(String[] args)  {
        try {
            DoubleLinkedList list = new DoubleLinkedList();
            System.out.println(list);
            list.addFront(1);
            System.out.println(list);
            list.addFront(2);
            System.out.println(list);
            list.addBack(3);
            System.out.println(list);
            list.addBack(4);
            System.out.println(list);
            list.remove(2);
            System.out.println(list);
            list.remove(2);
            System.out.println(list);
            list.remove(0);
            System.out.println(list);
            list.remove(0);
            System.out.println(list);
            list.remove(0);
            System.out.println(list);
            list.remove(0);
            System.out.println(list);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class DoubleLinkedList {
    private class Node {
        int value;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int count = 0;

    void addFront(int val) {
        Node newNode = new Node();
        newNode.value = val;

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        count++;
    }

    void addBack (int val){
        Node newNode = new Node();
        newNode.value = val;

        if (tail == null) {
            tail = newNode;
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        count++;
    }

    private void removeFirst() {
        Node temp;
        if((temp = head.next) == null) {
            head = null;
            tail = null;
        }
        else {
            temp.prev = null;
            head = temp;
            return;
        }
    }

    private void removeLast() {
        Node temp;
        if((temp = tail.prev) == null){
            tail = null;
            head = null;
        }
        else {
            temp.next = null;
            tail = temp;
        }
    }

    void remove (int n) {
        Node temp;
        if ((n > (count - 1)) || (n < 0) || (head == null))
            throw new IndexOutOfBoundsException("Wrong index!");
        else if (n == 0) {
            removeFirst();
            count--;
            return;
        }
        else if (n == count - 1) {
            removeLast();
            count--;
            return;
        }
        else {
            temp = head;
            for(int i = 0; i < n; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp = null;
            count--;
            return;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "null";
        }
        else {
            StringBuilder info = new StringBuilder("[");
            Node temp = head;
            while (temp != null){
                info.append(" " + temp.value);
                temp = temp.next;
            }
            info.append(" ]");
            return info.toString();
        }
    }
}

