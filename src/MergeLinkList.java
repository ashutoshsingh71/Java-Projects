import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeLinkList {
     public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode result = null;
          ListNode head = null;
          if(l1 == null && l2 == null){
               return result;
          }
          if(l1 == null && l2!= null){
               return l2;
          }
          if(l2 == null && l1!= null){
               return l1;
          }
          while(l1 != null || l2 != null){
               if(l1 == null && l2 != null){
                    result.next = l2;
               }else if(l1 != null && l2 == null){
                    result.next = l1;
               }else{
                    ListNode node;
                    head = result;
                    while((l1 != null && l2 != null) && l1.val >= l2.val){
                         node = new ListNode(l2.val);
                         result = node;
                         if(head == null){
                              head = result;
                         }
                         result = result.next;
                         l1 = l1.next;
                    }
                    while ((l1 != null && l2 != null) && l2.val >= l1.val){
                         node = new ListNode(l1.val);
                         result = node;
                         if(head == null){
                              head = result;
                         }
                         result = result.next;
                         l2 = l2.next;
                    }
               }

               /*if(l1.val >= l2.val){
                    node = new ListNode(l2.val);
               }else{
                    node = new ListNode(l1.val);
               }
               if(result == null){
                    result = node;
               }else {
                    result.next = node;
                    result = result.next;
               }

               if(head == null){
                    head = result;
               }
                    l1 = l1.next;
                    l2 = l2.next;
                    result = result.next;return
               }*/
          }
          return head;
     }

     public static void main(String [] args){
          int [] arr1 = {5};
          int [] arr2 = {1,2,4};
          ListNode l1 = null;
          ListNode head1 = null;
          ListNode l2 = null;
          ListNode head2 = null;
          for(int i : arr1){
               ListNode node = new ListNode(i);
               if(head1 == null){
                    l1 = node;
                    head1 = l1;
               }else{
                    l1.next = node;
                    l1 = l1.next;
               }
          }
          for(int i : arr2){
               ListNode node = new ListNode(i,null);
               if(head2 == null){
                    l2 = node;
                    head2 = l2;
               }else{
                    l2.next = node;
                    l2 = l2.next;
               }
          }
          ListNode result = mergeTwoLists(head1,head2);
          while(result != null){
               System.out.print(result.val + " ");
               result = result.next;
          }
     }
}
