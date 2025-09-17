package portContainerManagement;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        ArrayDeque<Container> containerStack = new ArrayDeque<>();
	        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();

	        int choice;

	        do {
	        	System.out.println();
	            System.out.println("=== Port Container Management System ===");
	            System.out.println("[1] Store container (push)");
	            System.out.println("[2] View port containers");
	            System.out.println("[3] Register arriving ship (enqueue)");
	            System.out.println("[4] View waiting ships");
	            System.out.println("[5] Load next ship (pop container + poll ship)");
	            System.out.println("[0] Exit");
	            System.out.print("Enter choice: ");

	            while (!sc.hasNextInt()) {
	                System.out.println("Invalid input. Enter a number.");
	                sc.next(); 
	            }
	            choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1: 
	                    System.out.print("Enter Container ID: ");
	                    String id = sc.nextLine();
	                    System.out.print("Enter Description: ");
	                    String desc = sc.nextLine();
	                    System.out.print("Enter Weight: ");
	                    String weight = sc.nextLine();

	                    Container c = new Container(id, desc, weight);
	                    containerStack.push(c);
	                    System.out.println();
	                    System.out.println("Stored: " + c);
	                    break;

	                case 2:
	                    if (containerStack.isEmpty()) {
	                    	System.out.println();
	                        System.out.println("No containers at the port.");
	                    } else {
	                    	System.out.println();
	                        System.out.println("TOP →");
	                        Iterator<Container> it = containerStack.iterator();
	                        while (it.hasNext()) {
	                            System.out.println(it.next());
	                        }
	                        System.out.println("← BOTTOM");
	                    }
	                    break;

	                case 3: 
	                    System.out.print("Enter Ship Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Captain Name: ");
	                    String captain = sc.nextLine();

	                    Ship s = new Ship(name, captain);
	                    shipQueue.add(s);
	                    System.out.println();
	                    System.out.println("Registered: " + s);
	                    break;

	                case 4: 
	                    if (shipQueue.isEmpty()) {
	                    	System.out.println();
	                        System.out.println("No ships waiting.");
	                    } else {
	                    	System.out.println();
	                        System.out.println("FRONT →");
	                        for (Ship ship : shipQueue) {
	                            System.out.println(ship);
	                        }
	                        System.out.println("← REAR");
	                    }
	                    break;

	                case 5: 
	                    if (containerStack.isEmpty() || shipQueue.isEmpty()) {
	                    	System.out.println();
	                        System.out.println("Cannot load: Missing containers or ships.");
	                    } else {
	                        Container loadedContainer = containerStack.pop();
	                        Ship nextShip = shipQueue.poll();
	                        System.out.println();
	                        System.out.println("Loaded: " + loadedContainer + " → " + nextShip);
	                        System.out.println("Remaining containers: " + containerStack.size());
	                        System.out.println("Remaining ships waiting: " + shipQueue.size());
	                    }
	                    break;

	                case 0:
	                	System.out.println();
	                    System.out.println("Ends Program!");
	                    break;

	                default:
	                	System.out.println();
	                    System.out.println("Invalid choice. Try again.");
	            }
	        } while (choice != 0);

	        sc.close();
		

	}

}
