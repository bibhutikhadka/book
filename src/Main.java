import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // VARIABLES
        Scanner myInput = new Scanner(System.in);
        ArrayList<Genre> genres = new ArrayList<Genre>();
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

        // GENRES STORING ARRAYLIST SECTION
        genres.add(new Genre("Fiction", "fictional works and facts created by the author.", 20));
        genres.add(new Genre("Science Fiction", " which explores stories by connecting realism and fiction", 12));
        genres.add(new Genre("Fantasy", " featuring magical, mystic, and mythical elements.", 18));
        genres.add(new Genre("Mystery", " centered around creating questions and solving them.", 10));
        genres.add(new Genre("Thriller", "built on creating suspense and excitement.", 14));


        // BOOKS STORING ARRAYLIST SECTION
        books.add(new Book("The Great Jellybean Heist of 3021", "B. Wacky", "adventure about a gang of jellybeans planning the ultimate heist.", 99.99f, 15, true, genres.get(0)));
        books.add(new Book("Aliens Love Pineapple Pizza Too", "S. Quirk", "exploration of intergalactic food preferences and the universal love for pineapple pizza.", 159.99f, 20, true, genres.get(2)));
        books.add(new Book("The Chronicles of the Talking Rubber Duck", "F. Giggly", " about a magical rubber duck that has epic conversations with bath toys.", 199.99f, 5, true, genres.get(3)));

        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre().getName());
            System.out.println("Description: " + book.getDescription());
            System.out.println("Price: Rs" + book.getPrice());
            System.out.println("Stock: " + book.getStock());
            System.out.println();
        }

        System.out.println("Enter your name:");
        String name = myInput.nextLine();

        System.out.println("Enter your email:");
        String email = myInput.nextLine();

        System.out.println("Enter your city:");
        String city = myInput.nextLine();

        System.out.println("Enter your resident number:");
        String residentNo = myInput.nextLine();

        Customer customer = new Customer(name, email, city, residentNo, 0);

        boolean ordering = true;
        while (ordering) {
            System.out.println("Which book do you want to order? (Enter a number corresponding to the book title)");
            int bookIndex = myInput.nextInt() - 1;
            if (bookIndex >= 0 && bookIndex < books.size()) {

                Book selectedBook = books.get(bookIndex);

                System.out.println("How many copies do you want?");
                int quantity = myInput.nextInt();

                if (quantity <= selectedBook.getStock()) {

                    OrderItem orderItem = new OrderItem(selectedBook, quantity);
                    orderItems.add(orderItem);
                    selectedBook.setStock(selectedBook.getStock() - quantity);

                    System.out.println("Successfully added to your cart.");
                } else {
                    System.out.println("Quantity is unavailable.");
                }
            } else {
                System.out.println("Invalid number.");
            }

            myInput.nextLine();

            System.out.println("Do you want to order more books? (Y/N)");
            String userChoice = myInput.nextLine();

            if (!userChoice.toUpperCase().equals("Y")) {
                ordering = false;
            }
        }

        Order order = new Order(customer, orderItems);
        float totalAmount = order.calculateTotal();
        System.out.println("Total amount for your order: Rs" + totalAmount);

        boolean paymentStatus = false;
        while (!paymentStatus) {
            System.out.println("Enter amount to pay:");
            float payment = myInput.nextFloat();
            if (payment >= totalAmount) {
                float userChange = payment - totalAmount;

                double[] cashNotes = {1000, 500, 100, 50, 20, 10, 5, 1};
                System.out.println("Your change is Rs. " + userChange);
                for (double noteNumber : cashNotes) {
                    if (userChange >= noteNumber) {
                        int noteCount = (int) (userChange / noteNumber);
                        userChange = (float)(userChange - noteCount * noteNumber);
                        System.out.println(noteCount + " Notes of Rs. " + noteNumber);
                    }
                }

                System.out.println("Thank you for your payment");
                order.process();
                paymentStatus = true;
            } else {
                System.out.println("Insufficient amount. Please pay the sufficient amount.");
            }
        }

        System.out.println("Order Summary:");
        for (OrderItem orderedBook : orderItems) {
            System.out.println("Book Title: " + orderedBook.getBook().getTitle() + ", Quantity: " + orderedBook.getQuantity());
        }
    }
}
