package com.mohammed.CustomDS;

public class DoublyLinkedList<E> {

    private DoublyLinkedListNode<E> dhead;
    private DoublyLinkedListNode<E> dtail;

    public DoublyLinkedList(){
        dhead = new DoublyLinkedListNode<>();
        dtail = new DoublyLinkedListNode<>();
        dhead.setNext(dtail);
        dtail.setPrev(dhead);
    }

    public void insertAtEnd(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> tail = dtail.getPrev();
        tail.setNext(node);
        node.setNext(dtail);
        node.setPrev(tail);
        dtail.setPrev(node);
    }

    public DoublyLinkedListNode<E> insertElementAtEnd(E element) {
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<E>();
        node.setElement(element);
        insertAtEnd(node);
        return node;
    }

    public void remove(DoublyLinkedListNode<E> node){
        if(isEmpty())
            throw new RuntimeException("DLL is empty");
        DoublyLinkedListNode<E> prev = node.getPrev();
        DoublyLinkedListNode<E> next = node.getNext();
        next.setPrev(prev);
        prev.setNext(next);
    }

    public E removeFromBeginning() {
        E element = dhead.getNext().getElement();
        remove(dhead.getNext());
        return element;
    }

    private Boolean isEmpty(){
        return dhead.getNext()==dtail.getPrev();
    }

}
