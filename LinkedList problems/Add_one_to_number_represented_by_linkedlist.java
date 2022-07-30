class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node prev, curr, NEXT;
        if(head == null || head.next == null)
        {
            head.data += 1;
            return head;
        }
        
        else{
            prev = curr = head;
            NEXT = head.next;
            
            while(NEXT!= null)
            {
                curr = NEXT;
                NEXT = NEXT.next;
                curr.next = prev;
                prev  = curr;
                
            }
            
            head.next = null;
            
            Node new_head = curr;
            curr = new_head.next;
            int carry = 0;
         
            new_head.data = new_head.data+=1;
            if(new_head.data > 9){
            carry = 1;
            new_head.data = (new_head.data)%10;
            }
            
            while(carry != 0 && curr!= null)
            {
                prev = curr;
                if(curr.data + 1 > 9 )
                {
                    curr.data = (curr.data+carry)%10;
                    carry = 1;
                    curr = curr.next;
                    if(curr == null)
                    break;
                }
                
                else{
                    curr.data +=1;
                    carry = 0;
                }
            }
            
            if(curr == null && carry != 0)
            {
                Node temp_node = new Node(1);
                prev.next = temp_node;
            }
            
            prev = new_head;
            curr = new_head;
            NEXT = new_head.next;
            
            while(NEXT != null)
            {
                curr = NEXT;
                NEXT = NEXT.next;
                curr.next = prev;
                prev = curr;
            }
            
            new_head.next = null;
            return curr;
            
        }
        
    }
}
