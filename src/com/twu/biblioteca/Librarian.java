package com.twu.biblioteca;

public class Librarian {
   Book[] books;
   public Librarian(Book[] books){
	   this.books=books;
   }
   
  
   public void listBooksForCustomer(){
	   for(int i=0;i<books.length;i++){
		   System.out.println(i+1+":"+books[i].name+books[i].detail()+" isCheckOut:"+books[i].isCheckout);
	   }
   }
   public void listBooksForLibaraian(){
	   for(int i=0;i<books.length;i++){
		   if(books[i].isCheckout==false){
			   System.out.println(i+1+":"+books[i].name+" author:"+books[i].Author);
		   }
	   }	   
   }
  
   
}
