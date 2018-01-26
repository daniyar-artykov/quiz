/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opertechnology;

import com.opertechnology.dto.LinkedNode;
import java.util.Scanner;

/**
 *
 * @author daniyar.artykov
 */
public class SinglyLinkedList {

    private LinkedNode firstNode;
    public int size;

    /**
     * Append an element into the linked list
     *
     * @param value
     */
    public void append(int value) {
        size++;
        firstNode = new LinkedNode(value, firstNode);
    }

    /**
     * Remove the tail element from a linked list
     *
     */
    public void removeTail() {
        if (firstNode == null) {
            return;
        }
        size--;
        LinkedNode tmp = firstNode;
        LinkedNode previous = null;
        while (tmp.getNext() != null) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        if (previous != null) {
            previous.setNext(null);
        }
    }

    /**
     * Remove all element in the linked list that is great than a target value
     *
     * @param targetValue
     */
    public void removeGreaterThan(int targetValue) {
        if (firstNode == null) {
            return;
        }
        LinkedNode current = firstNode;

        while (current.getNext() != null) {
            if (current.getNext().getValue() > targetValue) {
                size--;
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }

        if (firstNode.getValue() > targetValue) {
            firstNode = firstNode.getNext();
        }
    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (firstNode.getNext() == null) {
            sb.append(firstNode.getValue());
        } else {
            LinkedNode tmp = firstNode;
            while (tmp.getNext() != null) {
                sb.append(tmp.getValue()).append(", ");
                tmp = tmp.getNext();
            }
            sb.append(tmp.getValue());
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Singly Linked List\n");

        while (true) {
            System.out.println("1. Append an element into the linkedlist");
            System.out.println("2. Remove the tail element from a linkedlist");
            System.out.println("3. Remove all element in the linkedlist that is great than a target value");
            System.out.println("0. Exit application");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter int element to append");
                    list.append(sc.nextInt());
                    break;
                case 2:
                    list.removeTail();
                    break;
                case 3:
                    System.out.println("Enter target value");
                    list.removeGreaterThan(sc.nextInt());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println(list);
        }
    }
}
