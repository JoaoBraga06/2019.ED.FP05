/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;

import ListADT_Interfaces.OrderedListADT_Interface;
import Nodes.DoubleLinkedNode;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * ED - Estrutura de Dados<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Brito<br>
 * <strong>Description: </strong><br>
 * Class that represents a Double Linked Ordered List.
 * </p>
 *
 * @param <T>
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT_Interface<T>{

    public DoubleLinkedOrderedList() {
        super();
    }
    
    @Override
    public void add(T element) {
        int i=0;
        DoubleLinkedNode<T> newNode=new DoubleLinkedNode<>(element);
        DoubleLinkedNode<T> temp=front;
        Comparable tempElement=(Comparable)element;
        while(i<super.size() && tempElement.compareTo(temp.getElement())>0){
            i++;
            temp=temp.getNext();
        }
        if(super.size()==0){
            front=rear=newNode;
        } else if(i==0){
            front.setPrevious(newNode);
            newNode.setNext(front);
            front=newNode;
        } else if(i==super.size()){
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear=newNode;
        } else{
            newNode.setNext(temp);
            newNode.setPrevious(temp.getPrevious());
            temp.setPrevious(newNode);
            newNode.getPrevious().setNext(newNode);
        }
        count++;
        modCount++;
    }
    
}
