import java.util.Scanner;

/*
 * Program main - operation via command line.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 
 */


public class Main {


	private static ShoppingBasket basket = new ShoppingBasket();
	private static Product product = null; //implies 
	private static final Scanner scanInput = new Scanner(System.in);
	private static Item[] productList = Item.values();
	private static StringBuilder menuBuilder  = new StringBuilder();

	private static String userInput = "";
	private static long itemNumber;
	private static long itemPrice;
	private static boolean isFinished = true;

	
	public static void main(String[] args) {

		while(isFinished) {
			displayMenu();

			processItemNumber();
		}
		scanInput.close();
	}



	private static void processItemNumber() {

		if (userInput.equalsIgnoreCase("done")) {
			basket.printReceipt();
			isFinished = false;
		}

		if (!scanInput.hasNextInt()) {	
			System.out.println("ERROR: Invalid entry!" + System.getProperty("line.separator"));

			userInput = scanInput.nextLine();
			return;
		}
		itemNumber = scanInput.nextInt();

		if(itemNumber > productList.length || itemNumber < 1) {
			System.out.println("ERROR: Invalid item number!" + System.getProperty("line.separator"));
			return;
		}

		itemPrice = -1;
		while (itemPrice < 0) {
			System.out.println("Please input the item price, excluding the decimal (i.e. $12.99 input as 1299):");

			if (scanInput.hasNextLong()) {
				itemPrice = scanInput.nextLong();

				if(itemPrice >= 0) break;
			}
			System.out.println("ERROR: Invalid item price!" + System.getProperty("line.separator"));
			scanInput.next();
		}

		for(Item j: productList) {

			if(j.ordinal() == (itemNumber-1)) {
				String productDescription ="1 " + j.getDescription();
				
				product = new Product(productDescription, itemPrice, j);

				
				basket.selectProduct(product);
				System.out.println(">>> " + product.getDescription() + "added to cart <<<" + System.getProperty("line.separator"));
				break;
			}
		}
	}

	private static void displayMenu() {
		if(menuBuilder.length() == 0) {
			menuBuilder.append("Input item number or 'done' to checkout:");
			menuBuilder.append(System.getProperty("line.separator"));

			int i = 1;
			for(Item item: productList) {
				menuBuilder.append(i + ") ");
				menuBuilder.append(item.getDescription());
				menuBuilder.append(System.getProperty("line.separator"));

				i++;
			}
		}

		System.out.println(menuBuilder.toString() + System.getProperty("line.separator"));
	}
}
