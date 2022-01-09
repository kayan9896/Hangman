import java.util.Random;

public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    ListNode s;
    int size=0;
    public Solution(ListNode head) {
        ListNode s=head;
        ListNode s2=s;
        while(head!=null){
            s=head;
            s=s.next;
            head=head.next;
            size++;
        }
        s=s2;
    }

    public int getRandom() {
        int i=new Random().nextInt(size);
        ListNode h=s;
        for(int j=0;j<i;j++){
            s=s.next;
        }
        s=h;
        return s.val;
    }
}

