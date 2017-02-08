import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * Test class for 'Product' class.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/19/09
 */


@RunWith(Parameterized.class)
public class ProductTest {

	Product product;
	private String description;
	private long price, tax;
	private Item item;

	/*
	 * Creates product with associated data set information. 
	 */
	public ProductTest(String description, long price, long tax, Item item){
		this.description = description;
		this.price = price;
		this.tax = tax;
		this.item = item;
	}

	/**
	 * Data set to be tested.
	 * 
	 * @return collection of objects.
	 */
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
				{ "1 book", 1249, 0, Item.BOOK},
				{ "1 music CD", 1499, 150, Item.MUSIC_CD},
				{ "1 chocolate bar", 85, 0, Item.CHOCOLATE} ,
				{ "1 imported box of chocolates", 1000, 50, Item.IMPORTED_CHOCOLATE},
				{ "1 imported bottle of perfume", 4750, 713, Item.IMPORTED_PERFUME},
				{ "1 imported bottle of perfume", 2799, 420, Item.IMPORTED_PERFUME},
				{ "1 bottle of perfume", 1899, 190, Item.PERFUME},
				{ "1 packet of headache pills", 975, 0, Item.PILLS},
				{ "1 box of imported chocolates", 1125, 57, Item.IMPORTED_CHOCOLATE}});
	}

	/*
	 * Instantiates and sets object reference before each test.
	 */
	@Before 
	public void setUp() throws IllegalArgumentException {
		product = new Product(description, price, item);
	}

	/*
	 * Deallocates object reference after each test.
	 */
	@After
	public void tearDown() {
		product = null;
		
		assertNull(product);
	}

	/*
	 * Test of assigned product description.
	 */
	@Test
	public void testGetDescription() {
		assertEquals(description, product.getDescription());
	}

	/*
	 * Test of assigned product price.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(price, product.getPrice());
	}

	/*
	 * Test of assigned product tax.
	 */
	@Test
	public void testGetTax() {
		assertEquals(tax, product.getTax());
	}

	/*
	 * Test of assigned product total cost.
	 */
	@Test
	public void testGetTotalCost() {
		assertEquals(price + tax, product.getTotalCost());
	}

}
