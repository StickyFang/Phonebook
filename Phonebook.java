//Programmers: Bryce Nyswonger, Mae Wolf
//Date: 5/9/23
//Assignment: Phonebook
//References:https://www.geeksforgeeks.org/bubble-sort/#
//           Powerpoints from class
//           Used ChatGPT as a debugger
//IDE: VSCodium
//Phonebook program that allows users to add and view phonebook entries.
import java.util.LinkedList;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        LinkedList<Contact> userInputList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        //Classic Menu
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("a - Add to phonebook");
            System.out.println("e - Edit entry");
            System.out.println("d - Delete entry");
            System.out.println("v - View the list");

            System.out.println("x - Exit the program");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                // Saves each peice as a string then ports the inputs over to .contact
                //I also added a counter that keeps track of the number of entries added
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Contact contact = new Contact(userInputList.size() + 1, firstName, lastName, phoneNumber, address);
                    userInputList.add(contact);
                    System.out.println("Contact added.");
                    break;
                //case "e":
                
                case "v":
                System.out.println("Phonebook:");
                bubbleSort(userInputList);
                Format(userInputList);
                    break;
                case "x":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
            System.out.println();
        }
    }
    public static void Format(LinkedList<Contact> contactList) {
        // Format spacing
        //Uses array to create empty spaces that get subbed out for strings
        int[] columnWidths = new int[]{4, 20, 20, 15, 30};
    
        System.out.format("%-" + columnWidths[0] + "s%-"+ columnWidths[1] + "s%-"+ columnWidths[2] + "s%-"+ columnWidths[3] + "s%-" +columnWidths[4] +"s%n",
                "ID","First Name", "Last Name", "Phone Number", "Address");
    
        
        for (int width : columnWidths) {
            for (int j = 0; j < width; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
    
    
        for (Contact contact : contactList) {
            System.out.format("%-" + columnWidths[0] + "s%-"+ columnWidths[1] + "s%-"+ columnWidths[2] + "s%-"+ columnWidths[3] + "s%-" +columnWidths[4] + "s%n",
                   contact.id, contact.firstName, contact.lastName, contact.phoneNumber, contact.address);
        }
    }
    //This is a bubblesort algorthim I found online, I edited it it make it work for this class
    //It takes the First letter of a last name and compares it to the next item in the list.
    // If the item needs to be swapped it is stored as a temp then swapped.
    //This is apperently the simplest sorting algorithim ever,but still gave me a lot of trouble
    public static void bubbleSort(LinkedList<Contact> contacts) {
        boolean swapped;
        int listSize = contacts.size();
    
        for (int i = 0; i < listSize - 1; i++) {
            swapped = false;
            for (int j = 0; j < listSize - i - 1; j++) {
                if (contacts.get(j).lastName.compareToIgnoreCase(contacts.get(j + 1).lastName) > 0) {
                    // Swap contacts[j] and contacts[j + 1]
                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                    swapped = true;
                }
            }
    
            // once bubble sort runs without having to swap anything, sort will break
            if (!swapped) {
                break;
            }
        }
    }
    
    
    
}
