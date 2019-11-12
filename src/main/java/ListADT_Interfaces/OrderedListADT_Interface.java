/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT_Interfaces;
import Exceptions.*;

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
 * Interface for the ordered lists.
 * </p>
 *
 * @param <T>
 */
public interface OrderedListADT_Interface<T> extends ListADT_Interface<T> {

    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    public void add(T element);

}
