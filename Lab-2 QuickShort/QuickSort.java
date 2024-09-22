class QuickSortLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    void addToEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;  
        while (start != end) {
            if (start.data < pivot) {
                pivot_prev = curr;  
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        return pivot_prev;
    }
    void quickSortRec(Node start, Node end) {
        if (start == null || start == end || start == end.next) {
            return;
        }
        Node pivot_prev = partitionLast(start, end);
        quickSortRec(start, pivot_prev);
        if (pivot_prev != null && pivot_prev == start) {
            quickSortRec(pivot_prev.next, end);
        } else if (pivot_prev != null && pivot_prev.next != null) {
            quickSortRec(pivot_prev.next.next, end);
        }
    }
    Node getTail(Node node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }
    void quickSort() {
        Node tail = getTail(head);
        quickSortRec(head, tail);
    }
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void QuickSort(String[] args) {
        QuickSortLinkedList list = new QuickSortLinkedList();
        list.addToEnd(10);
        list.addToEnd(30);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToEnd(20);
        list.addToEnd(5);

        System.out.println("Linked List before sorting:");
        list.printList();
        list.quickSort();
        System.out.println("Linked List after sorting:");
        list.printList();
    }
}
