package prob1;
import java.util.*;

class LinkedModel{
	Node head;
	class Node{
		int data;
		Node next;
		Node(int val){
			this.data=val;
			this.next=null;
		}
	}
	LinkedModel(){
		head=null;
	}
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if(head==null) 
		{
			head= newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
	}
	public void dispaly() {
		Node temp= head;
		while(temp!=null)
		{
			System.out.print(temp.data+" "+temp.next+" ");
			System.out.println();
			temp=temp.next;
		}
	}
	public void insertAtPos(int pos, int val) {
		if(pos==0)
		{
			insertAtBeginning(val);
			return;
		}
		Node newNode=new Node(val);
		Node temp=head;
		for(int i=1;i<pos;i++) {
			temp=temp.next;
			if(temp==null)
			{
				System.out.println("Invalid pos");
				return;
			}
		}
		newNode.next=temp.next;
		temp.next=newNode;
	}
	public void deleteAtBeg(){
		if(head==null) {
			System.out.println("List is empty");
			return;
		}
		head=head.next;
	}
	public void deleteAtPos(int pos) {
		if(head==null) {
			System.out.println("Empty list");
			return;
		}
		if(pos==0) {
			deleteAtBeg();
			return;
		}
		Node temp=head;
		Node prev=null;
		for(int i=1;i<=pos;i++) {
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
	}
	public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
	public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LinkedListModel {
	public static void main(String[] args) {
		LinkedModel li=new LinkedModel();
		li.insertAtBeginning(10);
		li.insertAtBeginning(20);
		li.insertAtBeginning(30);
		li.dispaly();
		System.out.println("______________________________");
		li.insertAtPos(1, 25);
		li.dispaly();
		System.out.println("______________________________");
		li.deleteAtPos(2);
		li.dispaly();
		int targetValue = 30;
        if (li.search(targetValue)) {
            System.out.println(targetValue + " found in the linked list.");
        } else {
            System.out.println(targetValue + " not found in the linked list.");
        }
		System.out.println("______________________________");
        System.out.println(li.length());
	}

}
