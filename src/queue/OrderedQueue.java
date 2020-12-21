/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import list.ArrayList;

/**
 *
 * @author bilal
 */
public class OrderedQueue<T extends Comparable> {

    private list.List list = new ArrayList();

    public int size() {
        return list.size();
    }

    public void enqueue(T element) {
        // should be fine-tuned as follows:
        // 1- lookup for the right position where the element should be inserted
        // This can be done in Theta(log (n)) since the queue is sorted
        // 2- insert the element at that position
        // This is Theta(n)
        list.add(element);
        // Selection
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                T jthElement = (T) list.get(j);
                if (jthElement.compareTo(list.get(i)) < 0) {
                    list.swap(j, i);
                }
            }
        }
        // Bubble sort
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i; j < list.size() - 1; j++) {
//                T jthElement = (T) list.get(j);
//                if (jthElement.compareTo(list.get(j + 1)) < 0) {
//                    list.swap(j, j + 1);
//                }
//            }
//        }
        // Effect of adding anywhere then sorting:
        // 1- the array is continuously partially sorted
        // 2- sorting algorithms are Theta(n^2), and in MergeSort it is Theta(n log(n))
    }

    public T dequeue() {
        return (T) list.remove(0);
    }

    public static void main(String[] args) {
        OrderedQueue<String> q = new OrderedQueue<>();
        q.enqueue("Fouad");
        q.enqueue("Ziad");
        q.enqueue("Ahmad");
        q.enqueue("Mohamad");
        q.enqueue("Ali");

        System.out.println("First element is: " + q.dequeue());
        System.out.println("Second element is: " + q.dequeue());
        System.out.println("Third element is: " + q.dequeue());
        System.out.println("Fourth element is: " + q.dequeue());
        System.out.println("Fifth element is: " + q.dequeue());
    }
}
