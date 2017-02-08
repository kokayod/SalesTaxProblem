import java.util.Locale;

/*
 * Public API declaration for money conversion properties.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/19/09
 */


public interface MoneyConvertorInterface {

	/*
	 * Converts the non-decimal representation amount of currency to be displayed with the decimal; i.e. 1299 --> $12.99 USD.
	 * 
	 * @param amount	the non-decimal representation amount of currency; i.e. 1867 --> $18.67 USD.
	 * @param area		the specified geographic area
	 * @return the string representation of currency.
	 */
	public String convertMoney(long amount, Locale area);
}
