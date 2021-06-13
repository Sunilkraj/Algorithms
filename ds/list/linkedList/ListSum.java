package learn.ds.list.linkedList;

class ListSum {
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        int carry = 0, digit = 0;
        ListNode p = l1;
        ListNode q = l2;
        
        while (p != null || l2 != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            int sum = x + y + carry;
            
            digit = sum % 10;
            carry = sum / 10;
            
            result.next = new ListNode(digit);
            result = result.next;
            
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if (carry > 0){
            result.next = new ListNode(carry);
        }
        return temp.next;
    }*/
}
