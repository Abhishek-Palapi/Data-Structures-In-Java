package com.datastructures;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	Node head = null;
	int size = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.Add(1);
		list.Add(2);
		list.Add(3);
		list.traverse();
		System.out.println("size" + list.size());
		System.out.println("remove" + "3");
		System.out.println("get" + list.insertAt(1, 101));
		System.out.println("size" + list.size());
		list.traverse();
	}

	public void Add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
			this.size++;
		}
	}

	public int size() {
		return this.size + 1;
	}

	public void traverse() {
		if (this.head != null) {
			Node temp = this.head;
			while (temp != null) {
				System.out.println("data" + temp.data);
				temp = temp.next;
			}
		}
	}

	public Boolean update(int index, int data) {
		// checks the exception
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		// if index is 0 then move the head to next pointer
		if (index == 0) {
			this.head.data = data;
			return true;
		}

		Node temp = this.head;
		for (int i = 0; i < index && temp.next != null; i++) {
			temp = temp.next;
		}
		temp.data = data;
		return true;
	}

	public Boolean insertAt(int index, int data) {
		// checks the exception
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// if index is 0 then move the head to next pointer
		if (index == 0) {
			Node temp = this.head;
			Node newHead = new Node(data);
			this.head = newHead;
			newHead.next = temp;
			this.size++;
			return true;
		}
		// traverse the linked list find the node and remove the pointer
		Node temp = this.head;
		Node prev = this.head;
		for (int i = 0; i < index && temp.next != null; i++) {
			prev = temp;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = temp;
		this.size++;

		return true;
	}

	public int getData(int index) {
		// checks the exception
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// if index is 0 then move the head to next pointer
		if (index == 0) {
			return this.head.data;
		}
		// traverse the linked list find the node and remove the pointer
		Node temp = this.head;
		for (int i = 0; i < index && temp.next != null; i++) {
			temp = temp.next;
		}
		return temp.data;

	}

	public int remove(int index) {

		// checks the exception
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		// if index is 0 then move the head to next pointer
		if (index == 0) {
			Node temp = this.head;
			this.head = temp.next;
			this.size--;
			return temp.data;
		}
		// traverse the linked list find the node and remove the pointer
		Node temp = this.head;
		Node prev = this.head;
		for (int i = 0; i < index && temp.next != null; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		this.size--;
		return temp.data;

	}

}
