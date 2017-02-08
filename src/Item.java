/*
 * Item type definition for products.
 * 
 * @author Kent Kayode
 * @version 1.0
 * @since 2016/18/09
 */


public enum Item {
	
	BOOK(true, false, "book"),
	MUSIC_CD(false, false, "music CD"),
	CHOCOLATE(true, false, "chocolate"),
	PERFUME(false, false, "perfume"),
	PILLS(true, false, "headache pills"),

	IMPORTED_CHOCOLATE(true, true, "imported box of chocolates"),
	IMPORTED_PERFUME(false, true, "imported bottle of perfume");
	
//	BOOKS(true, false, "book"),
//	FOOD(true, false, "music CD"),
//	MEDICAL(true, false),
//	OTHER(false, false),
//
//	IMPORTED_BOOKS(true, true),
//	IMPORTED_FOOD(true, true),
//	IMPORTED_MEDICAL(true, true),
//	IMPORTED_OTHER(false, true);

	private boolean isExempt, isImport;
	private String description;

	/*
	 * Creates the enum-defined object.
	 * 
	 * @param exempt	exemption status of item
	 * 
	 * @param imported	import status of item
	 */
	private Item(boolean exempt, boolean imported, String description) {
		isExempt = exempt;
		isImport = imported;
		this.description = description;
	}

	/*ss
	 * Returns exemption status of product.
	 * 
	 * @return the exemption status
	 */
	boolean getExemption() {
		return isExempt;
	}
	
	/*
	 * Returns import status of product.
	 *
	 * @return the import status
	 */
	boolean getImport() {
		return isImport;
	}

	public String getDescription()
	{
		return description;
	}
	
}

