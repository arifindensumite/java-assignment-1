/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbl2librarysystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListOfBooks {

    /* Arraylist is used to store all the data relating to books */
    ArrayList<Integer> storeID = new ArrayList<Integer>();
    ArrayList<String> storeTitle = new ArrayList<String>();
    ArrayList<String> storeAuthor = new ArrayList<String>();
    ArrayList<String> storeYear = new ArrayList<String>();
    ArrayList<Integer> storeISBN = new ArrayList<Integer>();
    ArrayList<Integer> storeLevel = new ArrayList<Integer>();
    ArrayList<Integer> storeShelve = new ArrayList<Integer>();
    ArrayList<String> storeStatus = new ArrayList<String>();
    ArrayList<String> storeName = new ArrayList<String>();
    ArrayList<LocalDate> storeBorrow = new ArrayList<LocalDate>();
    ArrayList<LocalDate> storeReturn = new ArrayList<LocalDate>();

    public void CarianTroubleshoot(){

        LocalDate Pinjam = LocalDate.now();
        LocalDate Pulang = Pinjam.plusDays(7);

        storeID.add(2);
        storeTitle.add("Batu Belah Batu Bertangkup");
        storeAuthor.add("Ipin");
        storeYear.add("2-23-2323");
        storeISBN.add(12);
        storeLevel.add(12);
        storeShelve.add(12);
        storeStatus.add("n");
        storeName.add("Kamal");


        storeBorrow.add(Pinjam);
        storeReturn.add(Pulang);

        storeID.add(12);
        storeTitle.add("Puteri Gunug");
        storeAuthor.add("zal");
        storeYear.add("2-23-2323");
        storeISBN.add(12);
        storeLevel.add(12);
        storeShelve.add(12);
        storeStatus.add("y");
        storeName.add(null);
        storeBorrow.add(null);
        storeReturn.add(null);

        storeID.add(32);
        storeTitle.add("Puteri Kasturi");
        storeAuthor.add("zal");
        storeYear.add("2-23-2323");
        storeISBN.add(12);
        storeLevel.add(12);
        storeShelve.add(12);
        storeStatus.add("y");
        storeName.add(null);
        storeBorrow.add(null);
        storeReturn.add(null);

        storeID.add(9);
        storeTitle.add("Hang Tuah");
        storeAuthor.add("Ipin");
        storeYear.add("2-23-2323");
        storeISBN.add(12);
        storeLevel.add(12);
        storeShelve.add(12);
        storeStatus.add("y");
        storeName.add(null);
        storeBorrow.add(null);
        storeReturn.add(null);

        //Thread.sleep(2000);
    } // Delete after everything is done and work perfectly fine

}
