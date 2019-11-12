/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;
import Nodes.DoubleLinkedNode;
import ListADT_Interfaces.UnorderedListADT_Interface;
import Exceptions.NotFoundException;

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
 * Class that represents a Double Linked Unordered List.
 * </p>
 *
 * @param <T>
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT_Interface<T>{

    public DoubleLinkedUnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);
        if(size()==0)
            front=rear=newNode;
        else{
            newNode.setNext(front);
            front.setPrevious(newNode);
            front=newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);
        if(size()==0)
            rear=front=newNode;
        else{
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear=newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T elementToAdd) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(elementToAdd);
        DoubleLinkedNode<T> temp = super.find(element);
        try{
            if(temp==null)
                throw new NotFoundException();
            newNode.setPrevious(temp);
            if(temp.getNext()!=null){
                newNode.setNext(temp.getNext());
                temp.getNext().setPrevious(newNode);
            }
            temp.setNext(newNode);
            count++;
            modCount++;
        }catch(NotFoundException e){}
    }
    
}
