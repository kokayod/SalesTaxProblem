import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * 'ShoppingBasket' class implementation.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/18/09
 */

public class ShoppingBasket implements ShoppingBasketInterface
{

	private List<Product> productList;
	private long salesTax;
	private long totalCost;

	/*
	 * 
	 */
	ShoppingBasket()
	{
		productList = new ArrayList<Product>();
		salesTax = totalCost = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ShoppingBasketInterface#selectProduct(Product)
	 */
	@Override
	public void selectProduct(Product product)
	{
		productList.add(product);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see ShoppingBasketInterface#printReceipt()
	 */
	@Override
	public void printReceipt()
	{
		StringBuilder sb = new StringBuilder();

		for (Product pd : productList)
		{
			sb.append(pd.getDescription() + " at "
					+ convertMoney(pd.getTotalCost(), Locale.US)
					+ System.getProperty("line.separator"));
		}

		sb.append("Sales Taxes: " + convertMoney(calculateTax(), Locale.US)
				+ System.getProperty("line.separator"));

		sb.append("Total: " + convertMoney(calculateTotalCost(), Locale.US));

		System.out
				.println(sb.toString() + System.getProperty("line.separator"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#calculateTax()
	 */
	@Override
	public long calculateTax()
	{
		if (salesTax == 0)
			for (Product pd : productList)
				salesTax += pd.getTax();

		return salesTax;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#calculateTotalCost()
	 */
	@Override
	public long calculateTotalCost()
	{
		if (totalCost == 0)
			for (Product pd : productList)
				totalCost += pd.getTotalCost();

		return totalCost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see MoneyConvertorInterface#convertMoney(long, java.util.Locale)
	 */
	@Override
	public String convertMoney(long amount, Locale area)
	{
		double pay = (double) amount / 100;

		pay = Math.ceil(pay * 100) / 100;

		NumberFormat n = NumberFormat.getCurrencyInstance(area);

		return n.format(pay);
	}

}
