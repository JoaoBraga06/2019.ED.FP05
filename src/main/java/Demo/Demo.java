/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;
import Exceptions.EmptyCollecitonException;
import Exceptions.NotFoundException;
import ListADT.*;
import java.io.IOException;
import java.util.Scanner;
import ListADT_Interfaces.*;

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
 * Demo class.
 * </p>
 *
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollecitonException, NotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        int option=0;
        
        do{
            System.out.println("-----MENU-----"+"\n"+"\n"+"[0] Exit"+"\n"+"[1] Test Array Ordered List"+"\n"+"[2] Test Array Unordered List"+"\n"+
                    "[3] Test Double Linked Ordered List"+"\n"+"[4] Test Double Linked Unordered List"+"\n");
            option=scan.nextInt();
            for(int i=0;i<5;i++)
               System.out.println("\n"); 
            switch(option){
                case 1: 
                    System.out.println("---Test Array Ordered List---"+"\n");
                    OrderedListADT_Interface<String> ArrayOrderedList=new OrderedListADT<>();
                    ArrayOrderedList.add("Ana");
                    ArrayOrderedList.add("A");
                    ArrayOrderedList.add("Brito");
                    ArrayOrderedList.add("Braga");
                    ArrayOrderedList.add("José");
                    ArrayOrderedList.toString();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("---Test Array Unordered List---"+"\n");
                    UnorderedListADT_Interface<String> ArrayUnorderedList=new UnorderedListADT<>(2);
                    ArrayUnorderedList.addToFront("Alfredo");
                    ArrayUnorderedList.addToFront("Alberto");
                    ArrayUnorderedList.addToRear("João");
                    ArrayUnorderedList.addAfter("Alberto", "Sporting");
                    ArrayUnorderedList.addAfter("João", "Brito");
                    ArrayUnorderedList.toString();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("---Test Double Linked Ordered List---"+"\n");
                    OrderedListADT_Interface<String> DoubleLinkedOrderedList=new DoubleLinkedOrderedList<>();
                    DoubleLinkedOrderedList.add("Braga");
                    DoubleLinkedOrderedList.add("Brito");
                    DoubleLinkedOrderedList.add("Amaro");
                    DoubleLinkedOrderedList.add("Julio");
                    DoubleLinkedOrderedList.add("Ricardo");
                    System.out.println(DoubleLinkedOrderedList.toString());
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("---Test Double Linked Unordered List---"+"\n");
                    UnorderedListADT_Interface<String> DoubleLinkedUnorderedList=new DoubleLinkedUnorderedList<>();
                    DoubleLinkedUnorderedList.addToRear("Don Quixote");
                    DoubleLinkedUnorderedList.addToRear("LG");
                    DoubleLinkedUnorderedList.addAfter("Don Quixote", "Slimani");
                    DoubleLinkedUnorderedList.addToFront("Honor");
                    DoubleLinkedUnorderedList.addAfter("Honor", "ESTG");
                    DoubleLinkedUnorderedList.addAfter("LG", "Estrutura de Dados");
                    System.out.println(DoubleLinkedUnorderedList.toString());
                    System.out.println("\n");
            }
        }while(option!=0);
        
    }
    
}
