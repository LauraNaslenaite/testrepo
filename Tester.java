import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for calling and testing the methods of Tree class
 * @author Laura
 *
 */
public class Tester {
	
	private Tree aTree;
	
	/**
	 * Method for creating an instance of Tree class
	 */
	public void initialise()
	{
		aTree = new Tree();
	}
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Tester mytest = new Tester();
		mytest.initialise();
		mytest.process();
	}
	
	/**
	 * Method for calling the menu method
	 */
	public void process()
	{ 
		menu();
	}
	
	/**
	 * Method for running automated tests
	 */
	public void runAutomatedTests()
	{
		System.out.println(aTree.isEmpty());
		
		aTree.addNode(5, "A", 3.23);
		aTree.deleteNode1(5);
		
		aTree.addNode(5, "A", 3.23);
		aTree.addNode(2, "B", 3.34);
		aTree.addNode(1, "C", 3.56);
		aTree.addNode(4, "D", 3.54);
		aTree.addNode(3, "E", 3.45);
		aTree.addNode(6, "F", 3.40);
		aTree.addNode(12, "G", 3.43);
		aTree.addNode(10, "H", 3.48);
		aTree.addNode(20, "I", 3.49);
		aTree.addNode(19, "J", 3.41);
		aTree.addNode(21, "K", 3.52);

		System.out.println(aTree.isEmpty());

		aTree.printNode();
		
		aTree.addNode(12, "G", 3.43);
		
		if(aTree.search(10) != null)
			aTree.search(10).getInfo();
		else
			System.out.println("Node was not found");
		
		if(aTree.search(11) != null)
			aTree.search(11).getInfo();
		else
			System.out.println("Node was not found");
		
		aTree.sum();
		
		aTree.deleteNode1(21);
		aTree.printNode();
		
		aTree.deleteNode1(4);
		aTree.printNode();
		
		aTree.deleteNode1(6);
		aTree.printNode();
		
		aTree.deleteNode1(5);
		aTree.printNode();
		
		aTree.deleteNode1(7);
		
		aTree.setRoot(null);
	}
	
	/**
	 * Method for displaying menu options
	 */
	public void displayMenu()
	{
		System.out.println("Option 1 - run automated tests");
		System.out.println("Option 2 - add an item to the binary tree");
		System.out.println("Option 3 - print a binary tree according to ID");
		System.out.println("Option 4 - search for an item based on the item's ID");
		System.out.println("Option 5 - calculate the total cost of all items");
		System.out.println("Option 6 - delete an item from a tree");
		System.out.println("Option 0 - exit");
	}
	
	/**
	 * Method for choosing an option from displayMenu() method
	 */
	public void menu()
	{
		
		int option = 0;
		
		do
		{
			displayMenu();
			do 
			{
				option = validInt("Enter your option ");
			}while(option<0 || option > 6);
			
			switch(option)
			{
				case 1:
					System.out.println("");
					System.out.println("*******************");
					System.out.println("Run automated tests");
					System.out.println("*******************");
					runAutomatedTests();
					System.out.println("");

					break;
				case 2:
					System.out.println("");
					System.out.println("******************************");
					System.out.println("Add an item to the binary tree");
					System.out.println("******************************");
					addItem();
					System.out.println("");

					break;
				case 3:
					System.out.println("");
					System.out.println("***********************************");
					System.out.println("Print a binary tree according to ID");
					System.out.println("***********************************");
					aTree.printNode();
					System.out.println("");

					break;
				case 4:
					System.out.println();
					System.out.println("*****************************************");
					System.out.println("Search for an item based on the item's ID");
					System.out.println("*****************************************");
					searchItem();
					System.out.println("");

					break;
				case 5:
					System.out.println();
					System.out.println("*************************************");
					System.out.println("Calculate the total cost of all items");
					System.out.println("*************************************");
					aTree.sum();
					System.out.println("");

					break;
				case 6:
					System.out.println();
					System.out.println("**************************");
					System.out.println("Delete an item from a tree");
					System.out.println("**************************");
					deleteItem();
					System.out.println("");

					break;
			}
		}while(option!=0);
		
	}
	
	/**
	 * Method for adding nodes to a binary tree, each node is identified by data: id, name and price
	 * The process of adding nodes continues until user presses 0
	 */
	public void addItem()
	{
		int stop = 0;
		do
		{
			int id;
			do 
			{
				id = validInt("Enter item's ID (a number) ");
			}while(id<0);
			
			String name = validString();
			Double price = validDouble();
			
			if(aTree.search(id) == null)
			{
				aTree.addNode(id, name, price);
				System.out.println("");
				System.out.println("To stop adding items, press 0");
				System.out.println("To continue adding items, press 1");
				do 
				{
					stop = validInt("Enter your option ");
				}while(stop < 0 || stop > 1);
				
				System.out.println("");
			}
			
			else
			{
				System.out.println("Item is already added. Please, add another one.");
				stop = 1;
				System.out.println("");
			}
			
		}while(stop != 0);
		
	}
	
	/**
	 * Method for searching an item in a binary tree based on ID
	 * If it is found, item's name and price is displayed
	 */
	public void searchItem()
	{
		TreeNode found;
		int id;
		
		if(aTree.isEmpty() == true)
			System.out.println("Tree is empty");
		else
		{
			do 
			{
				id = validInt("Enter item's ID (a number) ");
			}while(id<0);
			
			if(aTree.search(id) == null)
			{
				System.out.println("Item was not found");
			}
			else
			{
				found = aTree.search(id);
				found.getInfo();
			}
		}
	}
	
	/**
	 * Method for deleting an item in a tree
	 */
	public void deleteItem()
	{
		int id;
		if(aTree.isEmpty() == true)
			System.out.println("Tree is empty");
		else
		{
			do 
			{
				id = validInt("Enter item's ID for deletion ");
			}while(id<0);
			
			if(aTree.search(id) == null)
			{
				System.out.println("Item could not be deleted, since it does not exist in the tree");
			}
			else
			{
				aTree.deleteNode1(id);
				System.out.println("Item was deleted");
			}
		}
	}
	
	/**
	 * Method for checking whether user's input is of valid int type
	 * @param text which is displayed for a user
	 * @return option for menu, ID of an item(node)
	 */
	public int validInt(String text)
	{
		Scanner s = new Scanner(System.in);
		int option = 0;
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print(text);
				option = s.nextInt();

				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s.next();
				
				valid = false;
			}
		}while(!valid);
		
		return option;
	}
	
	/**
	 * Method for checking whether user's input is of valid String type
	 * (if numerical data is entered, no exception is thrown since it is considered to be 
	 * of String type
	 * @return name for an item(node)
	 */
	public String validString()
	{
		Scanner s1 = new Scanner(System.in);
		String name = "";
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print("Enter item's name ");
				name = s1.nextLine();

				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s1.next();
				
				valid = false;
			}
		}while(!valid);
		
		return name;
	}
	
	/**
	 * Method for checking whether user's input is of valid double type
	 * @return price for an item (node)
	 */
	public double validDouble()
	{
		Scanner s2 = new Scanner(System.in);
		double price = 0.00;
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print("Enter item's price ");
				price = s2.nextDouble();

				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s2.next();
				
				valid = false;
			}
		}while(!valid);
		
		return price;
	}
}
