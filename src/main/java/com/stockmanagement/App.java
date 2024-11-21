package com.stockmanagement;

//import com.stockmanagement.dao.StockDao;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--------Stock Management System(Warehouse)-------------");
			System.out.println("1. Add Stock");
			System.out.println("2. Update Stock");
			System.out.println("3. Delete Stock");
			System.out.println("4. View Stocks");
			System.out.println("5. Exit");

			System.out.print("\nChoose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1 :
				StockDao.createStock();
				break;
			case 2 :
				StockDao.updateStock();
				break;
			case 3 :
				StockDao.deleteStock();
				break;
			case 4 :
				StockDao.viewStocks();
				break;
			case 5 :
			{
				System.out.println("Exiting...");
				System.exit(0);
			}
			default :
				System.out.println("Invalid option! Try again.");
			}
		}
	}
}
