/*
 * Public API declaration for tax calculator properties.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/18/09
 * 
 */


public interface TaxCalculatorInterface {

	static final long BASIC_TAX = 10; // denotes a %10 tax rate
	static final long IMPORT_TAX = 5; // denotes a %5 tax rate

	/*
	 * Calculates the tax amount.
	 * 
	 * @return tax amount
	 */
	long calculateTax();

	/*
	 * Calculates the total cost amount.
	 * 
	 * @return total cost amount
	 */
	long calculateTotalCost();
	
}
