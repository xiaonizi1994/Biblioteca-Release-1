package com.twu.biblioteca;

import java.util.Scanner;

public class mainMenu {
	public void mainMenuShow() {
		Book bookHongloumeng = new Book("xiyouji");
		bookHongloumeng.bookInfo("caoxueqing", "2005");
		Book bookXiyouji = new Book("hongloumeng");
		bookXiyouji.bookInfo("wuchengen", "2008");
		Book bookSanti = new Book("Santi");
		bookSanti.bookInfo("liucixing", "2016");
		bookSanti.isCheckout = true;
		Book[] books = { bookXiyouji, bookHongloumeng, bookSanti };
		Librarian librarian = new Librarian(books);
		menuChoose(books, librarian);
	}

	private void menuChoose(Book[] books, Librarian librarian) {
		System.out.println("1.List Books ");
		System.out.println("2.Quit ");
		System.out.println("please choose: ");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		if (choose == 1) {
			listBooks(librarian);
			// menuChooseBook(books, librarian);

		} else if (choose == 2) {
			Quit();
		} else {
			InvalidMenuOption();
			menuChoose(books, librarian);
		}
	}

	public void listBooks(Librarian librarian) {
		System.out.println("please choose what your role ");
		System.out.println("1.librarian ");
		System.out.println("2.customer ");
		System.out.println("3.Quit");
		Scanner scan = new Scanner(System.in);
		int roleChoose = scan.nextInt();
		if (roleChoose == 1) {
			librarian.listBooksForLibaraian();
		} else if (roleChoose == 2) {
			librarian.listBooksForCustomer();
			menuChooseBook(librarian);
		} else if (roleChoose == 3) {
			Quit();
		} else {
			InvalidMenuOption();
			listBooks(librarian);
		}

	}

	private void menuChooseBook(Librarian librarian) {
		System.out.println("please choose the book:");
		Scanner scan = new Scanner(System.in);
		int chooseBook = scan.nextInt();
		if (chooseBook > 0 && chooseBook <= librarian.books.length) {
			System.out.println(librarian.books[chooseBook - 1].name);
			chooseBookOperate(librarian.books[chooseBook - 1]);
		} else {
			InvalidMenuOption();
			menuChooseBook(librarian);
		}
	}

	private void chooseBookOperate(Book book) {
		System.out.println("please choose what your operate to this book: ");
		System.out.println("1.Checkout Book");
		System.out.println("2.Return Book");
		System.out.println("3.Quit ");
		Scanner scan = new Scanner(System.in);
		int chooseOperate = scan.nextInt();
		Customer customer = new Customer("lily");
		if (chooseOperate == 1) {

			book.checkoutBook(customer);
		} else if (chooseOperate == 2) {
			book.returnBook(customer);
		}
	}

	public void InvalidMenuOption() {
		System.out.println("Select a valid option!");
	}

	public void Quit() {
		System.exit(0);
	}

}
