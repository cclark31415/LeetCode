import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * 
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * 
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public static void main(String[] args){
        AddTwoNumbers solution = new AddTwoNumbers();
        int[] l1 = { 2, 4, 9};
        int[] l2 = { 5, 6, 4, 9};
        ListNode l1Node = solution.createListNode(l1);
        ListNode l2Node = solution.createListNode(l2);
        ListNode result = solution.addTwoNumbers(l1Node, l2Node);
        System.out.println(result.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        List<Integer> sumArray = new ArrayList<>();
        while(l1.next != null || l2.next != null){
            if(l1.next == null){
                if (l2.val > 9) {
                    l2.val = l2.val % 10;
                    if (l2.next == null) {
                        l2.next = new ListNode();
                    }
                    l2.next.val += 1;
                }
                int sum = l1.val + l2.val;
                
                if (sum > 9) {
                    sum = sum % 10;
                    if (l2.next == null) {
                        l2.next = new ListNode();
                    }
                    l2.next.val += 1;
                }

                l1.val = 0;
                sumArray.add(sum);
                l2 = l2.next;
            } else if(l2.next == null){
                if (l1.val > 9) {
                    l1.val = l1.val % 10;
                    if(l1.next == null){
                        l1.next = new ListNode();
                    }
                    l1.next.val += 1;
                }
                int sum = l1.val + l2.val;

                if (sum > 9) {
                    sum = sum % 10;
                    if (l1.next == null) {
                        l1.next = new ListNode();
                    }
                    l1.next.val += 1;
                }

                l2.val = 0;
                sumArray.add(sum);
                l1 = l1.next;
            } else {
                int sum = l1.val + l2.val;
                if(sum > 9){
                    sum = sum % 10;
                    if (l1.next == null) {
                        l1.next = new ListNode();
                    }
                    l1.next.val += 1;
                }
                sumArray.add(sum);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(l1.next == null && l2.next == null){            
            int sum = l1.val + l2.val;
            if (sum > 9) {
                sum = sum % 10;
                sumArray.add(sum);
                sumArray.add(1);
            } else {
                sumArray.add(sum);
            }
        }
        int[] resultArray = new int[sumArray.size()];
        for(int r = 0; r < sumArray.size(); r++){
            resultArray[r] = sumArray.get(r);
        }
        result = createListNode(resultArray);
        return result;
    }
    
    public ListNode createListNode(int[] nums){
        ListNode result = new ListNode();
        ListNode thisListNode = result;

        for(int n = 0; n < nums.length; n++){ 
            thisListNode.val = nums[n];
            if(n < nums.length - 1){
                thisListNode.next = new ListNode();
                thisListNode = thisListNode.next;
            }
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }

        ListNode(int val) { 
            this.val = val; 
        }

        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
        
        public String toString(ListNode node) {
            StringBuilder result = new StringBuilder();
            while (node.next != null) {
                result.append(node.val);
            }
            if (node.next == null) {
                result.append(node.val);
            }
            return result.toString();
        }
    }
}
