/*
 * Public API declaration for product properties.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/17/09
 */


public interface ProductInterface {

	/*
	 * Returns the description of the product.
	 * 
	 * @return description of the product
	 */
	String getDescription();

	/*
	 * Returns the price of the product.
	 * 
	 * @return price of product
	 */
	long getPrice();

	/*
	 * Returns the tax amount of the product.
	 * 
	 * @return tax amount of product
	 */
	long getTax();


	/*
	 * Calculates and returns the total amount of the product, including tax.
	 * 
	 * @return total cost of product
	 */
	long getTotalCost();

}
