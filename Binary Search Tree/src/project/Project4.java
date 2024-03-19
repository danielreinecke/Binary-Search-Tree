package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* COP 3530: Project 4 – Binary Search Trees
* <p>
* This program uses a Binary Search tree to store data about countries that are given in a file
* as well as implement all of the normal methods with a Binary tree such as find,add, and delete
* <p>
* It also allows the tree to be print in three different ways in-order, post-order and pre-order as
* well as being about to find a specified about of the largest and smallest countries based on happiness
* index
* <p>
* The program will not fail on incorrect input and instead will tell you "invalid input" then
* prompt the user for new input.
* @author Daniel Reinecke
* @version 11/17/2023
*/
public class Project4 {

	/** The country. */
	private static Country country[] = new Country[128];
	
	/** The tree. */
	private static BinarySearchTree tree = new BinarySearchTree();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		System.out.println("COP3530 Project 4\nInstructor: Xudong Liu\n\nBinary Search Trees\n");
		Scanner scnr = new Scanner(System.in);
		boolean fileFound = false;
		while(!fileFound)
		{
			try
			{
				fileFound = readFile(scnr);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Invaild file please give a diffrent fie");
			}
		}
		
		createTree();
		boolean end = false;
		
		while(!end)
		{
			end = options(scnr);
		}
	}
	
	/**
	 * Reads in the file
	 *
	 * @param scnr the scnr
	 * @return true, if successful
	 * @throws FileNotFoundException the file not found exception
	 */
	public static boolean readFile(Scanner scnr) throws FileNotFoundException
	{
		System.out.print("Enter the file Name: ");
		String fileName = scnr.nextLine();
		File file = new File(fileName);
		
		Scanner out = new Scanner(file);
		out.nextLine();
		out.useDelimiter("[,\n]");
		int i = 0;
		while(out.hasNext())
		{
			String name = out.next();
			String capitol = out.next();
			String population = out.next();
			String GDP = out.next();
			String area = out.next();
			String happinessIndex = out.next();

			Country cont = new Country(name, capitol, population, GDP , area , happinessIndex);
			country[i] = cont;
			i++;
		}
		out.close();
		return true;
	}
	
	/**
	 * Creates the Binary Search tree.
	 */
	public static void createTree()
	{
		for(int i = 0; i < country.length; i++)
		{
			tree.insert(country[i].getName(), Double.parseDouble(country[i].getsetHappinessIndex()));
		}
	}
	
	/**
	 * Allows the user to pick from the options until ordered to stop
	 *
	 * @param scnr the scnr
	 * @return true, if successful
	 */
	public static boolean options(Scanner scnr)
	{
		System.out.println("1) Print tree inorder");
		System.out.println("2) Print tree preorder");
		System.out.println("3) Print tree postorder");
		System.out.println("4) Insert a country with name and happiness");
		System.out.println("5) Delete a country for a given name");
		System.out.println("6) Search and print a country and its path for a given name");
		System.out.println("7) Print bottom countries regarding happinesst");
		System.out.println("8) Print top countries regarding happiness");
		System.out.println("9) Exit\n");
		System.out.print("Enter Choice: ");
		
		int choice = 0;
		boolean valid = false;
		while(!valid)
		{
			try
			{
				choice = scnr.nextInt();
				
				if(choice < 1 || choice > 9)
				{
					System.out.print("Please enter a number between 1 - 9: ");
				}
				
				else
				{
					valid = true;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.print("Please enter a number between 1 - 9: ");
				scnr.next();
			}
		}
		
		
		switch(choice)
		{
			case 1:
				tree.printInorder();
				return false;
			case 2:
				tree.printPreorder();
				return false;
			case 3:
				tree.printPostorder();
				return false;
			case 4:
				scnr.nextLine();
				boolean error = false;
				while(!error)
				{
					try
					{
						System.out.print("Please enter the countries Name: ");
						String name = scnr.nextLine();
						System.out.print("Please enter the countries happiness: ");
						double happy = scnr.nextDouble();
						tree.insert(name,happy);
						error = true;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please give a valid input");
						scnr.nextLine();
					}
				}
				return false;
			case 5:
				scnr.nextLine();
				System.out.print("Enter Country Name: ");
				String name = scnr.nextLine();
				tree.delete(name);
				return false;
			case 6:
				scnr.nextLine();
				System.out.print("Enter Country Name: ");
				name = scnr.nextLine();
				tree.find(name);
				return false;
			case 7:
				scnr.nextLine();
				while(true)
				{
					try
					{
						System.out.print("Enter the number of countries: ");
						int amount = scnr.nextInt();
						if(amount < 0)
						{
							System.out.println("Please enter a postive number");
						}
						else
						{
							tree.printBottomCountries(amount);
							return false;
						}
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid input please enter a number");
						scnr.nextLine();
					}
				}
			case 8:
				scnr.nextLine();
				while(true)
				{
					try
					{
						System.out.print("Enter the number of countries: ");
						int input = scnr.nextInt();
						if(input < 0)
						{
							System.out.println("Please enter a postive number");
						}
						else
						{
						tree.printTopCountries(input);
						return false;
						}
					}
					catch(InputMismatchException e)
					{
					System.out.println("Invalid input please enter a number");
					scnr.nextLine();
					}
					
				}
			case 9:
				System.out.println("Have a great day!!");
				return true;
			default:
				System.out.println("please give a number between 1-9");
				return false;
		}
	}

}