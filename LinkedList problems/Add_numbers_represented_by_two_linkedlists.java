/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode newListHead = null, temp1 = l1, temp2 = l2, newTemp=null;

        int carry = 0;
        while(temp1 != null || temp2!= null)
        {
            int newVal = 0;
            if(temp1 == null)
            {
                newVal = temp2.val + carry;
                temp2 = temp2.next;
                if(newVal > 9)
                {
                    newVal-=10;
                    carry = 1;
                }

                else
                {
                    carry = 0;
                }

                if(newListHead == null)
                {
                    newListHead = new ListNode(newVal);
                    newTemp = newListHead;
                }

                else 
                {
                    ListNode temp = new ListNode(newVal);
                    newTemp.next = temp;
                    newTemp = temp;
                }
            }

            else if(temp2 == null)
            {
                newVal = temp1.val + carry;
                temp1 = temp1.next;
                if(newVal > 9)
                {
                    newVal-=10;
                    carry = 1;
                }

                else
                {
                    carry = 0;
                }

                if(newListHead == null)
                {
                    newListHead = new ListNode(newVal);
                    newTemp = newListHead;
                }

                else 
                {
                    ListNode temp = new ListNode(newVal);
                    newTemp.next = temp;
                    newTemp = temp;
                }
            }

            else
            {
                newVal = temp2.val + temp1.val + carry;
                temp1 = temp1.next;
                temp2 = temp2.next;
                if(newVal > 9)
                {
                    newVal-=10;
                    carry = 1;
                }

                else
                {
                    carry = 0;
                }

                if(newListHead == null)
                {
                    newListHead = new ListNode(newVal);
                    newTemp = newListHead;
                }

                else 
                {
                    ListNode temp = new ListNode(newVal);
                    newTemp.next = temp;
                    newTemp = temp;
                }
            }
        }

        if(temp1 == null && temp2 == null && carry != 0)
        {
                    ListNode temp = new ListNode(1);
                    newTemp.next = temp;
                    newTemp = temp;
        }

        return newListHead;


    }
}
