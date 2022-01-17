package LinkedLists;

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        LinkedList runner = head;
        LinkedList tail = head;

        for (int i = 0; i < k + 1; i++) {
            runner = runner.next;
        }
        if (runner == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (runner.next != null) {
            runner = runner.next;
            tail = tail.next;
        }

        tail.next = tail.next.next;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
