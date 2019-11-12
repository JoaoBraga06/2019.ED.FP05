/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;
import Exceptions.*;
import ListADT_Interfaces.*;
import java.util.Iterator;
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
 * Class that represents a Double Linked List.
 * </p>
 *
 * @param <T>
 */
public class DoubleLinkedList<T> implements ListADT_Interface<T> {
    protected DoubleLinkedNode<T> front, rear;
    protected int count;
    protected int modCount;

    public DoubleLinkedList() {
        front=null;
        rear=null;
        count=0;
        modCount=0;
    }

    public class BasicIterator<T> implements Iterator<T> {

        private DoubleLinkedNode current;
        private final int expectedmodcount;

        public BasicIterator() {
            this.current = front;
            this.expectedmodcount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectedmodcount != modCount) {
                throw new Error();
            }
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new Error();
            }
            T tmp = (T) current.getElement();
            current = current.getNext();
            return tmp;
        }

    }
    
    @Override
    public T removeFirst() throws EmptyCollecitonException {
        if(isEmpty())
            throw new EmptyCollecitonException();
        T temp=front.getElement();
        if(size()==1){
            front=null;
            rear=null;
        } else{
            front=front.getNext();
            front.setPrevious(null);
        }
        count--;
        modCount++;
        return temp;
    }

    @Override
    public T removeLast() throws EmptyCollecitonException {
        if(isEmpty())
            throw new EmptyCollecitonException();
        T temp=rear.getElement();
        if(size()==1){
            front=null;
            rear=null;
        } else{
            rear=rear.getPrevious();
            rear.setNext(null);
        }
        count--;
        modCount++;
        return temp;
    }

    @Override
    public T remove(T element) throws EmptyCollecitonException, NotFoundException {
        if(isEmpty())
            throw new EmptyCollecitonException();
        if(!contains(element))
            throw new NotFoundException();
        DoubleLinkedNode<T> temp=find(element);
        if(size()==1){
            front=null;
            rear=null;
        } else if(temp.getPrevious()==null){
            front=front.getNext();
            front.setPrevious(null);
        } else if(temp.getNext()==null){
            rear=rear.getPrevious();
            rear.setNext(null);
        } else{
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
            
        count--;
        modCount++;
        return temp.getElement();
    }

    @Override
    public T first() throws EmptyCollecitonException {
        return front.getElement();
    }

    @Override
    public T last() throws EmptyCollecitonException {
        return rear.getElement();
    }

    @Override
    public boolean contains(T target){
        boolean found=false;
        Iterator i = iterator();
        while(i.hasNext() && !found){
            Comparable temp = (Comparable) i.next();
            if(temp.compareTo(target)==0){
                found=true;
            }
        }
        return found;
        
        //OU UTILIZAR O METODO FIND()
    }

    @Override
    public boolean isEmpty() {
        return(count==0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<T>();
    }
    
    @Override
    public String toString(){
        String result="";
        Iterator i= iterator();
        while(i.hasNext()){
            result+="\n"+i.next().toString();
        }
        return result;
    }
    
    protected DoubleLinkedNode<T> find(T element){
        boolean found=false;
        DoubleLinkedNode<T> temp=front;
        while(temp!=null && !found){
            Comparable tempElement=(Comparable) temp.getElement();
            if(tempElement.compareTo(element)==0)
                found=true;
            else
                temp=temp.getNext();
        }
        if(!found)
            temp=null;
        return temp;
    }
}
