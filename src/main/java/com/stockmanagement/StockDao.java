package com.stockmanagement;
//import com.stockmanagement.entity.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class StockDao {
	private static SessionFactory factory;

	static {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Stock.class)
				.buildSessionFactory();
	}

	public static void createStock() {
		try (Session session = factory.openSession()) {
			Scanner scanner = new Scanner(System.in);

			
			System.out.print("Enter stock ID : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter product name: ");
			String name = scanner.nextLine();
			
			
			System.out.print("Enter Batch No.: ");
			int batchno = scanner.nextInt();
			
			System.out.print("Enter quantity: ");
			int quantity = scanner.nextInt();

			System.out.print("Enter price: ");
			int price = scanner.nextInt();

			Stock stock = new Stock();
			stock.setStockId(id);
			stock.setName(name);
			stock.setBatchno(batchno);
			stock.setQuantity(quantity);
			stock.setPrice(price);

			session.beginTransaction();
			session.save(stock);
			session.getTransaction().commit();

			System.out.println("Stock added successfully!");
		}
	}

	public static void updateStock() {
		try (Session session = factory.openSession()) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter stock ID to update: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			//System.out.print("Enter new product name: ");
			//String name = scanner.nextLine();

			System.out.print("Enter new Batch No.: ");
			int batchno = scanner.nextInt();
			
			System.out.print("Enter new quantity: ");
			int quantity = scanner.nextInt();

			System.out.print("Enter new price: ");
			int price = scanner.nextInt();

			session.beginTransaction();
			Stock stock = session.get(Stock.class, id);
			if (stock != null) {
				//stock.setName(name);
				stock.setBatchno(batchno);
				stock.setQuantity(quantity);
				stock.setPrice(price);
				session.update(stock);
				session.getTransaction().commit();
				System.out.println("Stock updated successfully!");
			} else {
				System.out.println("Stock not found!");
			}
		}
	}

	public static void deleteStock() {
		try (Session session = factory.openSession()) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter stock ID to delete: ");
			int id = scanner.nextInt();

			session.beginTransaction();
			Stock stock = session.get(Stock.class, id);
			if (stock != null) {
				session.delete(stock);
				session.getTransaction().commit();
				System.out.println("Stock deleted successfully!");
			} else {
				System.out.println("Stock not found!");
			}
		}
	}

	public static void viewStocks() {
		try (Session session = factory.openSession()) {
			List<Stock> stocks = session.createQuery("from Stock", Stock.class).list();
			for (Stock stock : stocks) {
				System.out.println(stock);
			}
		}
	}
}
