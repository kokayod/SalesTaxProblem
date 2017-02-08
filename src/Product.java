/*
 * 'ProductInterface' class implementation.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 
 */


public class Product implements ProductInterface {

	private String description;
	private long price;
	private Item item;

	
	public Product(String description, long price, Item item) {
		this.description = description;
		this.price = price;
		this.item = item;
	}

	/*
	 * (non-Javadoc)
	 * @see ProductInterface#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * @see ProductInterface#getPrice()
	 */
	@Override
	public long getPrice() {
		return price;
	}

	/*
	 * (non-Javadoc)
	 * @see ProductInterface#setTax()
	 */
	@Override
	public long getTax() {
		long tax = 0;
		double temp = 0;

		if (!item.getExemption()){
			temp = (double) (TaxCalculatorInterface.BASIC_TAX * price)/10000;
			tax += Math.ceil(temp * 100);
		}

		if (item.getImport()){
			temp = (double) (TaxCalculatorInterface.IMPORT_TAX * price)/10000;
			tax += Math.ceil(temp * 100);
		}
		
		return tax;
	}

	/*
	 * (non-Javadoc)
	 * @see ProductInterface#getTotalCost()
	 */
	@Override
	public long getTotalCost() {
		
		return price + getTax();
	}

}
