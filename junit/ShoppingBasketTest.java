import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * Test class for 'ShoppingBasket' class.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/18/09
 */


@RunWith(Parameterized.class)
public class ShoppingBasketTest{

	private ShoppingBasket basket;
	private List<Product> productList;
	private long salesTax;
	private long totalCost;

	/*
	 * Creates product with associated data set information. 
	 */
	public ShoppingBasketTest(List<Product> productList, long salesTax, long totalCost) {
		this.productList = productList;
		this.salesTax = salesTax;
		this.totalCost = totalCost;
	}

	/*
	 * Data set to be tested.
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		List<Object[]> al = (List<Object[]>) ProductTest.testData();

		return Arrays.asList(new Object[][] {
				{ shoppingBasket(new Object[][]{al.get(0), al.get(1), al.get(2)}), 150, 2983},

				{ shoppingBasket(new Object[][]{al.get(3), al.get(4)}), 763, 6513},

				{ shoppingBasket(new Object[][]{al.get(5), al.get(6), al.get(7), al.get(8)}), 667, 7465}});
	}

	/*
	 * Helper method to create list of products.
	 * 
	 * @return list of products
	 */
	private static List<Product> shoppingBasket(Object[][] objects) {
		List<Product> lp = new ArrayList<Product>();

		for (Object[] obj: objects) {
			Product p = new Product();

			p.setDescription((String) obj[0]);
			p.setPrice((int) obj[1]);
			p.setItem((Item) obj[3]);
			p.setTax();
			p.getTotalCost();
			lp.add(p);
		}
		return lp;
	}

	/*
	 * Instantiates object reference before each test.
	 */
	@Before
	public void setUp() {
		basket = new ShoppingBasket();
	}

	/*
	 * Deallocates object reference after each test.
	 */
	@After
	public void tearDown() {
		basket = null;
		
		assertNull(basket);
	}

	/*
	 * Test for the tax amount and total cost for each order.
	 */
	@Test
	public void testSelectProduct() {
		for (Product p: productList) basket.selectProduct(p);

		basket.printReceipt();
		assertEquals(salesTax, basket.calculateTax());
		assertEquals(totalCost, basket.calculateTotalCost());
	}

}
