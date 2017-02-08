/*
 * Public API declaration for shopping cart properties.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/16/09
 */


public interface ShoppingBasketInterface extends TaxCalculatorInterface, MoneyConvertorInterface {

	/*
	 * Adds product to shopping cart.
	 * 
	 * @param	product the product to be added to cart
	 */
	void selectProduct(Product product);

	/*
	 * Displays items, pricing, and total cost of shopping cart.
	 */
	void printReceipt();

}
