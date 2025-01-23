import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList d1= new DoublyLinkedList();

        int choice;
        while(true)
        {
            System.out.println("1. Insert Element 2. Delete element 3. Display List 0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int insertElement = scanner.nextInt();
                    d1.insertAtEnd(insertElement);
                    break;

                case 2:
                    System.out.print("Enter element to delete: ");
                    int deleteElement = scanner.nextInt();
                    d1.deleteElement(deleteElement);
                    break;

                case 3:
                    System.out.println("List:");
                    d1.display();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    return ;
                    
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } 
    }
}
class Node {
    int data;
    Node Llink;
    Node Rlink;

    public Node(int data) {
        this.data = data;
        this.Llink = null;
        this.Rlink= null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public void insertAtEnd(int data) {
        Node n1 = new Node(data);
        if (head == null) {
            head = n1;
        } else {
            Node current = head;
            while (current.Rlink != null) {
                current = current.Rlink;
            }
            current.Rlink = n1;
            n1.Llink= current;
        }
    }

    
    public void deleteElement(int key) {
        Node current = head;
        
        while (current != null && current.data != key) {
            current = current.Rlink;
        }

        
        if (current == null) {
            System.out.println("Element " + key + " not found in the list.");
            return;
        }
        
        if (current.Llink != null) {
            current.Llink.Rlink = current.Rlink;
        } else {
           
            head = current.Rlink;
        }

        if (current.Rlink != null) {
            current.Rlink.Llink = current.Llink;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.Rlink;
        }
        System.out.println();
    }
}
