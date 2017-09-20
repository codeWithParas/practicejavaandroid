package com.example.logicprogram.datastructure.LinearDS.linkedlistDS;

/**
 * Created by parasmani.sharma on 03/06/2017.
 */

public class LinkedListExample
{

    Node head;

    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    public static void main(String[] args)
    {
        LinkedListExample linkList = new LinkedListExample();

        //create nodes....linkedlist start from head
        linkList.head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(5);

        //attach each node
        linkList.head.next = second;
        second.next = third;


        //2,3,5
        linkList.push(1);                    // push new node at first position
        linkList.insertAfter(second,4 );     //insert after previous node
        linkList.insertAtLast(third,6 );     //insert at last position


        //traverse each node
        linkList.printNodeList();

        linkList.printMiddle();

        linkList.removeNode(1);

        linkList.printNodeList();

        linkList.printMiddle();

        linkList.reverse();

        linkList.printNodeList();


    }

    /* Function to reverse the linked list */
    Node reverse()
    {

        //help : just draw the diagrams of all required nodes, connect each node and mention next , prev , head
        //now reverse all the arrows position
        //assign each value corresponding to each node point

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /* Function to print middle of linked list */
    void printMiddle()
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public void insertAfter(Node prev_node, int data)
    {
        if(prev_node == null)
        {
            System.out.print("Previous node cannot be Null");
            return;
        }

        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;

    }

    public void insertAtLast(Node prev_lastNode, int data)
    {
        if(prev_lastNode == null)
        {
            System.out.print("Previous node cannot be Null");
            return;
        }

        Node new_node = new Node(data);
        new_node.next = null;
        prev_lastNode.next = new_node;
    }


    private void removeNode(int i)
    {

        Node n = head;
        System.out.print("Head Node : " + n.data);


        Node prevNode = null;
        Node deletingNode = null;
        boolean isPreviousNodeFound = false;
        while (n != null)
        {
            if(i == n.data)
            {
                deletingNode = n;
                isPreviousNodeFound = true;
            }

            if(!isPreviousNodeFound)
            {
                prevNode = n;
            }
            n = n.next;
        }

        System.out.print("\n\nDeleting node is " + deletingNode.data);


        //
        Node nextNode = deletingNode.next;
        System.out.print("\n Is Next Node is Found : "+nextNode.data);

        if(prevNode != null)
        {
            System.out.print("\n Is Previous Node is Found : "+prevNode.data);
            prevNode.next = nextNode;
        }
        else {
            //if deleting node is head
            //head.next = nextNode;
            head = nextNode;
        }


    }





    private void printNodeList() {

        Node n = head;
        System.out.print("\n\n");
        while (n != null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }

        System.out.print("\n\n");
    }


}
