public class LinkedList {
    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if(this.head != null){
            node.setNext(this.head);
        }
        head = node;

    }

    public void addLast(int val) {
        ListNode node = new ListNode(val);
        ListNode temp = this.head;
        if(this.head != null) {
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        else{
            head = node;
        }

    }

    public void deleteFirst() {
        if(this.head != null){
            this.head = this.head.getNext();
        }
    }

    public void printList() {
        System.out.println();
        System.out.println("Below is the linkedlist:");
        ListNode temp = this.head;
        if(this.head != null) {
            while(temp != null) {
                System.out.print(temp.getValue() + ", ");
                temp = temp.getNext();
            }
        }
    }

    public void reverse() {
        ListNode current = this.head, previous = null;
            while (current != null) {
                ListNode next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            }
            head = previous;
    }

    public boolean hasCycle() {
        ListNode slow = this.head, fast = this.head;
        while(fast != null && fast.getNext() != null){
            slow  = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
                return true;
        }
        return false;
    }

    public ListNode findMiddle() {
        ListNode slow = this.head, fast = this.head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
