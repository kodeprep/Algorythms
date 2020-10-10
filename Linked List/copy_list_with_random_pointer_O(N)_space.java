/*
    Practice link:- https://leetcode.com/problems/copy-list-with-random-pointer
    Time Complexity :- O(N)
    Space Complexity :- O(N)
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Edge case
        if(head == null) return null;
        Node origCurr = head;
        Node dummy = new Node(0);
        Node newCurr = dummy;
        int size = 0;
        // Make the corresponding new nodes and start to chain them up.
        while(origCurr != null){
            Node newNode = new Node(origCurr.val);
            newCurr.next = newNode;
            newCurr = newCurr.next;
            origCurr = origCurr.next;
            size++;
        }
        // remember what were the next pointers of nodes in the original list because we will scramble them
        Node[] origNext = new Node[size];
        // point the new nodes random to corresponding original and original next should point to corresponding to new nodes
        newCurr = dummy.next;
        origCurr = head;
        int index = 0;
        while(origCurr != null){
            origNext[index] = origCurr.next;
            index++;
            newCurr.random = origCurr;
            Node temp = origCurr.next;
            origCurr.next = newCurr;
            origCurr = temp;
            newCurr = newCurr.next;
        }
        // Fix the random pointers at their correct place.
        newCurr = dummy.next;
        while(newCurr != null){
            if(newCurr.random.random != null)
                newCurr.random = newCurr.random.random.next;
            else
                newCurr.random = null;
            newCurr = newCurr.next;
        }
        
        // restore the original linked list
        origCurr = head;
        index = 0;
        while(origCurr != null){
            origCurr.next = origNext[index];
            index++;
            origCurr = origCurr.next;
        }

        return dummy.next;
    }
}
