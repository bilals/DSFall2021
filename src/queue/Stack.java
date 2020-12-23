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
public class Stack {

    private list.List list = new ArrayList();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void push(Object element) {
        list.add(element);
    }

    public Object pop() {
        return list.remove(list.size() - 1);
    }

    public void display() {
        list.display();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("Val 1");
        s.push("Val 2");
        s.push("Val 3");
        System.out.println("Before the copy:");
        s.display();
        Stack reverseCopyOfS = s.reverseCopy();
        System.out.println("After the reverse copy, the copy is:");
        reverseCopyOfS.display();
        System.out.println("After the reverse copy, original becomes:");
        s.display();

        Stack copyOfS = s.copy();
        System.out.println("After the copy, the copy is:");
        copyOfS.display();
        System.out.println("After the copy, original becomes:");
        s.display();
    }

    private Stack reverseCopy() {
        Stack copy = new Stack();
        recursiveReverseCopy(this, copy);
        return copy;
    }

    private void recursiveReverseCopy(Stack original, Stack copy) {
        if (original.isEmpty()) {
            return;
        }
        final Object top = original.pop();
        copy.push(top);
        recursiveReverseCopy(original, copy);
        original.push(top);
        return;
    }

    private Stack copy() {
        Stack copy = new Stack();
        recursiveCopy(this, copy);
        return copy;
    }

    private void recursiveCopy(Stack original, Stack copy) {
        if (original.isEmpty()) {
            return;
        }
        final Object top = original.pop();
        recursiveCopy(original, copy);
        copy.push(top);
        original.push(top);
        return;
    }

}
