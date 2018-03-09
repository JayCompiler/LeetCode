package solution.first_fifty;
/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, 
	except the number 0 itself.
	Example

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
 * @author zy
 *
 */
public class Second {
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		l1.next.next.next=null;
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		l2.next.next.next=null;
		ListNode reS=addTwoNumbers(l1, l2);
		print(reS);
	}

	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode a=l1;
	        ListNode b=l2;
	        ListNode re1=new ListNode(0);
	        ListNode re=re1;
	        if((a==null)&&(b==null)){
	            return null;
	        }
         int count=0;
	        while(a!=null || b!=null||count==1){
	            if(a==null&&b!=null){
	                re1.val=(b.val+count)%10;
                  if(b.val+count>=10){
                     count=1;
                 }else{
                     count=0;
                 }
	                b=b.next;
                 if(b!=null||count==1){
                     re1.next=new ListNode(0);
                     re1=re1.next;
                 }        
	            }else if(b==null&&a!=null){
	                re1.val=(a.val+count)%10;
                  if(a.val+count>=10){
                     count=1;
                 }else{
                     count=0;
                 }
	                a=a.next;
                  if(a!=null||count==1){
                     re1.next=new ListNode(0);
                     re1=re1.next;
                 }
	            }else if(a==null&&b==null&&count==1){
                 re1.val=count;
                 count=0;
             }else{
	                re1.val=(a.val+b.val+count)%10;
                 if(a.val+b.val+count>=10){
                     count=1;
                 }else{
                     count=0;
                 }
	                a=a.next;
	                b=b.next;
                 if(a!=null || b!=null||count==1){
                     re1.next=new ListNode(0);
                     re1=re1.next;
                 } 
	            }
	        }
	        return re;
 }
	 public static void print(ListNode l) {
		 System.out.print("(");
		 while(l!=null) {
			 if(l.next!=null) {
				 System.out.print(l.val+"->");
				 l=l.next;
			 }else {
				 System.out.print(l.val);
				 break;
			 }
		 }
		 System.out.print(")");
	 }
}
