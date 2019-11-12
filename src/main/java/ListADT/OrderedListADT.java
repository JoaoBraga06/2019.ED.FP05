/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;

import Exceptions.EmptyCollecitonException;
import ListADT_Interfaces.*;
import java.util.Collections;

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
 * Class that represents a Array Ordered List.
 * </p>
 *
 * @param <T>
 */
public class OrderedListADT<T> extends ListADT<T> implements OrderedListADT_Interface<T> {

    public OrderedListADT() {
        super();
    }

    public OrderedListADT(int initalSize) {
        super(initalSize);
    }

    @Override
    public void add(T element){           
        int i=0;
        if(super.size()==super.arrayList.length)
            super.expandCapacity();
        Comparable temp=(Comparable) element;
        while(i<size() && temp.compareTo(arrayList[i])>0)
            i++;
        for(int j=size();j>i;j--){
            arrayList[j]=arrayList[j-1];
        }
        arrayList[i]=element;
        super.rear++;
    }
    
}
