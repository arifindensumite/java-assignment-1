/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to BookStorage this license
 */

package com.mycompany.pbl2librarysystem;

import java.time.LocalDate;
import java.util.Scanner;
//Version 2
public class PBL2LibrarySystem {

    public static void main(String[] args) {
        int choice = 0;

        Scanner in = new Scanner(System.in);
        Books books = new Books();

        books.BookStorage.CarianTroubleshoot();

        do {
            System.out.print("Selamat datang ke sistem library XYZ\n\nMenu Utama\n\n1.Buku\n2.Carian\n3.Pinjam\n4.Pulang buku\n5.Display laporan faulty\n6. Keluar\nSelection: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    books.Menu();
                    break;
                case 2:
                    books.Carian();
                    break;
                case 3:
                    books.Pinjam();
                    break;
                case 4:
                    books.Pulang();
                    break;
                case 5:
                    books.DisplayLaporanFaulty();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nThe choice selected is unavailable\n");
            }
        }while(choice > 0 && choice < 6);
    }
}

class Books{
    LocalDate TarikhPinjam = LocalDate.now();
    LocalDate TarikhPulang = TarikhPinjam.plusDays(7);
    Scanner in; //Scanner input
    ListOfBooks BookStorage; //BooksLibrary
    int choice;
    public Books(){
        BookStorage = new ListOfBooks();
        in = new Scanner(System.in);
    }

    public void Menu(){

        do{
            System.out.print("\n\nMenu Buku:\n\n1. Tambah Buku\n2. Delete Buku\n3. Display Buku\n4. Keluar\n\nSelection: ");
            choice = in.nextInt();

            switch(choice){
                case 1:
                    AddBooks();
                    break;
                case 2:
                    DeleteBooks();
                    break;
                case 3:
                    DisplayBooks();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nSila membuat pilihan yang tepat\n");
            }
        }while(choice > 0 && choice < 4);
    }
    
    public void AddBooks(){

        System.out.print("\nNo. ID: ");
        int BookID = in.nextInt();
        int index = BookStorage.storeID.indexOf(BookID);

        if(index != -1 ){
            System.out.println("Buku dengan ID " + BookID + " telah wujud di dalam stor penyimpanan");
        }

        else{
            BookStorage.storeID.add(BookID);

            System.out.print("\nTile: ");
            String BookTitle = in.nextLine();
            BookTitle = in.nextLine();
            BookStorage.storeTitle.add(BookTitle);

            System.out.print("\nAuthor: ");
            String Author = in.nextLine();
            BookStorage.storeAuthor.add(Author);

            System.out.print("\nTahun published (00-00-0000): ");
            String Year = in.nextLine();
            BookStorage.storeYear.add(Year);

            System.out.print("\nNo. ISBN: ");
            int ISBN = in.nextInt();
            BookStorage.storeISBN.add(ISBN);

            System.out.print("\nLokasi\nTingkat: ");
            int Level = in.nextInt();
            BookStorage.storeLevel.add(Level);

            System.out.print("\nRak: ");
            int Shelve = in.nextInt();
            BookStorage.storeShelve.add(Shelve);

            System.out.print("\nAvailability\nStatus(y/n):");
            String ava = in.nextLine();
            ava = in.nextLine();
            BookStorage.storeStatus.add(ava);

            String notavailable = "n";

            if (ava.equals(notavailable)){

                System.out.print("\nNama Peminjam: ");
                String Name = in.nextLine();
                BookStorage.storeName.add(Name);

                System.out.print("Tarikh Pinjam: ");
                BookStorage.storeBorrow.add(TarikhPinjam);
                System.out.println(TarikhPinjam);

                System.out.print("Tarikh Pulang: ");
                BookStorage.storeReturn.add(TarikhPulang);
                System.out.println(TarikhPulang);
            }
            else{
                BookStorage.storeName.add(null);
                BookStorage.storeBorrow.add(null);
                BookStorage.storeReturn.add(null);
            }
            System.out.println("Buku dengan ID " + BookID + " Berjaya ditambah");
        }

    }
    
    public void DeleteBooks() {

        System.out.print("Delete Buku\n\nNo. ID buku untuk di padam: ");
        int IdDelete = in.nextInt();

        int Index = BookStorage.storeID.indexOf(IdDelete);
        System.out.print("Are you sure you want to delete '" + BookStorage.storeTitle.get(Index) + "' ");
        System.out.print("(y/n) : ");
        String confirmation = in.nextLine();
        confirmation = in.nextLine();
        if(confirmation.equals("y")){
        //Remove all the data related to Book with the same index as the input IdDelete.
        BookStorage.storeID.remove(Index);
        BookStorage.storeTitle.remove(Index);
        BookStorage.storeAuthor.remove(Index);
        BookStorage.storeYear.remove(Index);
        BookStorage.storeLevel.remove(Index);
        BookStorage.storeShelve.remove(Index);
        BookStorage.storeStatus.remove(Index);
        BookStorage.storeName.remove(Index);
        BookStorage.storeBorrow.remove(Index);
        BookStorage.storeReturn.remove(Index);
        
        System.out.println();
        }
        else{
            System.out.println("Book deletion has been canceled");
        }
    }
    
    public void DisplayBooks(){

        System.out.println("\nDisplay buku\n");

        for(int i = 0; i < BookStorage.storeID.size(); i++) {
            System.out.println("No ID : " + BookStorage.storeID.get(i));
            System.out.println("Title : " + BookStorage.storeTitle.get(i));
            System.out.println("Author : " + BookStorage.storeAuthor.get(i));
            System.out.println("Tahun Published : " + BookStorage.storeYear.get(i));
            System.out.println("No.ISBN : " + BookStorage.storeISBN.get(i));
            System.out.println("Book Location");
            System.out.println("Book Level : " +BookStorage.storeLevel.get(i));
            System.out.println("Book Shelve : " +BookStorage.storeShelve.get(i));
            System.out.println("Availibity : " + BookStorage.storeStatus.get(i));
            System.out.println();
            if(BookStorage.storeStatus.get(i).equals("n")){
                System.out.println("Nama Peminjam : " + BookStorage.storeName.get(i));
                System.out.println("Tarikh Pinjam : " + BookStorage.storeBorrow.get(i));
                System.out.println("Tarikh Pulang : " + BookStorage.storeReturn.get(i));
                System.out.println();
            }
        }
    }

    public void Carian(){ //linear search
        String search = null;
        int totalsearchresult = 0;

        System.out.println("\nMenu Carian\n");
        System.out.print("Sila masukkan title untuk di cari : ");
        search = in.nextLine();

        for(String result : BookStorage.storeTitle){
            if (result.contains(search)){
                int index = BookStorage.storeTitle.indexOf(result);

                if(index != -1){
                    totalsearchresult++;
                    System.out.println("No ID : " + BookStorage.storeID.get(index));
                    System.out.println("Title : " + BookStorage.storeTitle.get(index));
                    System.out.println("Author : " + BookStorage.storeAuthor.get(index));
                    System.out.println("Tahun Published : " + BookStorage.storeYear.get(index));
                    System.out.println("No.ISBN : " + BookStorage.storeISBN.get(index));
                    System.out.println("Book Location");
                    System.out.println("Book Level : " +BookStorage.storeLevel.get(index));
                    System.out.println("Book Shelve : " +BookStorage.storeShelve.get(index));
                    System.out.println("Availibity : " + BookStorage.storeStatus.get(index));
                    System.out.println();
                    if(BookStorage.storeStatus.get(index).equals("n")){
                        System.out.println("Tarikh Pulang : " + BookStorage.storeReturn.get(index));
                        System.out.println();
                    }
                }

            }
        }
        System.out.println("Jumlah carian yang dijumpai adalah sebanyak : " + totalsearchresult);
        System.out.println();
    }

    public void Pinjam(){
        String Input = null;

        System.out.println("\nPinjam Buku\n");
        System.out.print("No ID Buku : ");
        int input = in.nextInt();
        int index = BookStorage.storeID.indexOf(input);

        if(BookStorage.storeID.get(index) == -1){
            System.out.println("Buku ID " + input + " tidak wujud di dalam sistem");
        }

        else if(BookStorage.storeStatus.get(index).equals("y")){
            System.out.print("Nama Peminjam : ");
            Input = in.nextLine();
            Input = in.nextLine();
            BookStorage.storeName.set(index, Input);

            BookStorage.storeBorrow.set(index, TarikhPinjam);
            System.out.print("Tarikh Pinjam : ");
            System.out.println(BookStorage.storeBorrow.get(index));

            BookStorage.storeReturn.set(index, TarikhPulang);
            System.out.print("Tarikh Pulang : ");
            System.out.println(BookStorage.storeReturn.get(index));


            BookStorage.storeStatus.set(index, "n");
            System.out.println("\nProses peminjaman buku berjaya dilaksanakan");
        }
        else{
            System.out.println("Buku yang dicari tidak dapat dijumpai\n");
        }
    }

    public void Pulang(){

        System.out.println("\nPulang Buku\n");
        System.out.print("No ID Buku : ");
        int input = in.nextInt();
        int index = BookStorage.storeID.indexOf(input);

        if(index == -1){
            System.out.println("Buku ID " + input + " tidak wujud di dalam sistem");
        }

        else if(BookStorage.storeStatus.get(index).equals("n")){
            BookStorage.storeName.set(index, null);
            BookStorage.storeBorrow.set(index, null);
            BookStorage.storeReturn.set(index, null);

            BookStorage.storeStatus.set(index, "y");
            System.out.println("\nProses pemulangan buku berjaya dilaksanakan");
        }

        else{
            System.out.println("Buku yang dicari tidak dipinjam oleh orang lain");
        }

    }

    public void DisplayLaporanFaulty(){
        System.out.println("\nDisplay Laporan Faulty\n");
        System.out.println("Buku yang masih belum dipulangkan:\n");



        for(int i = 0; i < BookStorage.storeID.size(); i++){
            if(BookStorage.storeStatus.get(i).equals("n")){

                LocalDate currentdate = LocalDate.now();

                System.out.print("-------------------------------------------------------------\n");
                System.out.printf("| %-14s | %40s |\n" ,"Title", BookStorage.storeTitle.get(i));
                System.out.print("-------------------------------------------------------------\n");
                System.out.printf("| %-14s | %40s |\n" ,"Nama Peminjam:", BookStorage.storeName.get(i));
                System.out.print("-------------------------------------------------------------\n");
                System.out.printf("| %-14s | %40s |\n" , "Tarikh Pulang", BookStorage.storeReturn.get(i));
                System.out.print("-------------------------------------------------------------\n");

                if (currentdate.isAfter(BookStorage.storeBorrow.get(i))){
                    System.out.printf("| %-14s | %40s |\n" , "Status", "Book is overdue");
                    System.out.print("-------------------------------------------------------------\n");

                }
                else{
                    System.out.printf("| %-14s | %40s |\n" , "Status", "Book is not overdue");
                    System.out.print("-------------------------------------------------------------\n");
                }
            }
        }
    }
}
