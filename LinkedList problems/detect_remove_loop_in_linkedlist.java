class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node fast, slow;
        fast = head;
        slow = head;
        Node prev = fast;
        int flag = 0;
        
        if(head.next == null)
        {}
        
        
    else{
        while(fast.next != null)
        {
            fast = fast.next.next;
            if(fast == null)
            {
                return;
            }
            slow = slow.next;
            
            if(fast == slow)
            {
                flag = 1;
                break;
            }
            
            if(slow.next == head)
            {
                slow.next = null;
                return;
            }
        }
        
        if(flag == 1)
        {
            slow = head;
            while(slow != fast)
            {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            
            if(fast.next == head)
            {
                fast.next = null;
            }
            
            else
            prev.next = null;
        }
    }
        
    }
}
