package cst8132.sarray;

/**
 * Custom java exception class to use with StringArray class
 * 
 * @author Madhav Sachdeva
 * @version 1.1
 * @since 1.8
 */
public class CapacityOutOfBoundsException extends RuntimeException {

	/**
	 * Default Constructor to call super default constructor
	 */
	public CapacityOutOfBoundsException() {
		super();// calling super constructor
	}

	/**
	 * Initial Constructor to call super Initial Constructor passing a string
	 * 
	 * @param s
	 *            String
	 */
	public CapacityOutOfBoundsException(String s) {
		super(s);// calling super constructor
	}

}
