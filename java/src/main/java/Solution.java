import java.util.*;

public class Solution {
    /**
     * 接雨水
     */
    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int lh = 0;
        int rh = 0;
        while (l < r){
            if(height[l] <= height[r]){
                lh = Math.max(lh, height[l]);
                res = res + lh - height[l];
                l++;
            } else {
                rh = Math.max(rh, height[r]);
                res = res + rh - height[r];
                r--;
            }
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(half);
        return mergeListNode(left, right);
    }
    private ListNode mergeListNode(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeListNode(l1, l2.next);
            return l2;
        }
    }
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int tmp = 0;
        int res = nums[0];
        for(int i  = 0; i < nums.length; i++){
            int num = nums[i];
            tmp = Math.max(tmp + num, num);
            res = Math.max(res, tmp);
        }
    }
    public static void main(String[] args) {

    }
}
