
class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public Node sortedMerge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    public Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null; 
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle); 
        return sortedMerge(left, right);
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(15);
        list.push(10);
        list.push(5);
        list.push(20);
        list.push(3);
        list.push(2);

        System.out.println("Original Linked List:");
        list.printList(list.head);

        list.head = list.mergeSort(list.head);

        System.out.println("Sorted Linked List:");
        list.printList(list.head);
    }
}
