package lab2;

import java.util.Scanner;

public class LinkedList {
	static class listNode{
		int data;
		listNode next;
		listNode()
		{
			this.data = 0;
			this.next = null;
		}
		listNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	private listNode head, tail;
	public LinkedList()
	{
		head = null;
		tail = null;
	}
	public void createNode(int value)
	{
		listNode newNode = new listNode(value);
		if (head == null)
		{
			head = newNode;
			tail = newNode;
			newNode = null;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}
	public void display()
	{
		listNode nodePtr = head;
		while (nodePtr != null)
		{
			System.out.println(nodePtr.data + "-->");
			nodePtr = nodePtr.next;
		}
		System.out.println("NULL");
	}
	public void insertStart(int value)
	{
		listNode nodePtr = new listNode(value);
		nodePtr.next = head;
		head = nodePtr;
	}
	public void insertLast(int value)
	{
		listNode nodePtr =new listNode(value);
		tail.next = nodePtr;
		tail = nodePtr;
	}
	public void insertPosition(int pos, int value)
	{
		listNode newNode = new listNode(value);
		listNode pre = new listNode();
		listNode cur = new listNode();
		cur = head;
		for (int i = 1; i < pos; i++)
		{
			pre = cur;
			cur = cur.next;
		}
		pre.next = newNode;
		newNode.next = cur;
	}
	public void deleteFirst()
	{
		if(head != null)
			head = head.next;
		else 
			return;
	}
	public void deleteLast()
	{
		if(tail != null)
		{
			listNode nodePtr = new listNode();
			nodePtr = head;
			for (; nodePtr.next != tail; )
			{
				nodePtr = nodePtr.next;
			}
			tail = nodePtr;
			tail.next = null;
		}
	}
	public void deletePosition(int pos)
	{
		listNode current = new listNode();
		listNode previous =new listNode();
		current = head;
		for(int i = 1; i < pos; i++)
		{
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList mylist = new LinkedList();
		int n;
		System.out.println("List size = ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//sc.close();
		//Scanner inputValue = new Scanner(System.in);
		for(int i = 1; i <= n ; i++)
		{
			int value;
			System.out.println("\nValue of node "+i+" : ");
			value = sc.nextInt();
			mylist.createNode(value);
		}
		//inputValue.close();
		sc.close();
		mylist.display();
		mylist.insertStart(8);
		mylist.insertLast(5);
		mylist.insertPosition(3,6);
		mylist.display();
		mylist.deleteFirst();
		mylist.display();
	}

}
