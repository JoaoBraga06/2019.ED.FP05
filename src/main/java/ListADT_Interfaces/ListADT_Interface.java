/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT_Interfaces;

import Exceptions.EmptyCollecitonException;
import Exceptions.NotFoundException;
import java.util.Iterator;

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
 * Interface for the classes Array List and Double Linked List.
 * </p>
 *
 * @param <T>
 */
public interface ListADT_Interface<T> {

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    public T removeFirst() throws EmptyCollecitonException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    public T removeLast() throws EmptyCollecitonException;

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollecitonException, NotFoundException;

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    public T first() throws EmptyCollecitonException;

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    public T last() throws EmptyCollecitonException;

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString();

}