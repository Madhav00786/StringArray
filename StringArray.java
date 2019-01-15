package cst8132.sarray;

/**
 * Class contains the logical methods for the working of a string array
 * 
 * @author Madhav Sachdeva
 * @version 1.1
 * @since 1.8
 */
public class StringArray {
	// This class contains the logic for a dynamic array of Strings

	private int capacity; // current capacity of the array

	private int size; // current size of the array

	private String[] stringArray; // current String Array

	/**
	 * Default Constructor to set the capacity
	 */
	public StringArray() {
		// Default constructor, Constructs an empty StringArray with an initial capacity
		// of ten.

		capacity = 10;// initial capacity as 10
		stringArray = new String[capacity];
	}

	/**
	 * Initial Constructor to set the given capacity
	 * 
	 * @param initialCapacity
	 *            Capacity to be set
	 * @throws IllegalArgumentException
	 */
	public StringArray(int initialCapacity) throws IllegalArgumentException {
		// Initial constructor, Constructs an empty StringArray with the specified
		// initial capacity.

		try {
			capacity = initialCapacity;// initial capacity specified
			stringArray = new String[capacity];
		} catch (IllegalArgumentException e) {
			if (initialCapacity < 0) {
				throw new IllegalArgumentException("Capacity Negative");
			}
		}

	}

	/**
	 * Copy Constructor to create a deep copy
	 * 
	 * @param sa
	 *            String array to be copied
	 * @throws NullPointerException
	 */
	public StringArray(StringArray sa) throws NullPointerException {
		// Copy constructor, Constructs a StringArray that is a copy of a given
		// StringArray

		// this.stringArray=sa.stringArray;
		// System.arrayopy(stringArray, 0, sa, 0, 10);

		try {
			for (int i = 0; i < size; i++) {
				if (stringArray[i] != null) {
					stringArray[i] = sa.stringArray[i];// getting all the values from stringArray to
														// newSA(newStringArray)
				}
			}
		} catch (NullPointerException e) {
			if (sa.equals(null)) {
				throw new NullPointerException("Array Null");
			}
		}

	}

	/**
	 * Method to add the specified string in the stringArray
	 * 
	 * @param s
	 *            String to be append
	 * @throws NullPointerException
	 */
	public void add(String s) throws NullPointerException {
		// Appends the specified string to the end of this StringArray. Increases
		// capacity if needed.

		try {
			ensureCapacity(size + 1);// ensuring the capacity as (size+1)
			this.stringArray[size] = s;
		} catch (NullPointerException e) {
			if (s.equals(null)) {
				throw new NullPointerException("String  Null");
			}
		}
	}

	/**
	 * Method to add the specified string at specified position
	 * 
	 * @param index
	 *            Index at which the string is to be added
	 * @param s
	 *            String to be added
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException
	 */
	public void add(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		// Inserts the specified string at the specified position in this StringArray.
		// Increases capacity if needed.

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index not Valid");
		}

		if (s.equals(null)) {
			throw new NullPointerException("String  Null");
		}

		if (index > size) {
			ensureCapacity(index + 1);
		}

		this.stringArray[index] = s;// inserting string at index

	}

	/**
	 * Method to return the Capacity of the Array
	 * 
	 * @return Capacity of the Array
	 */
	public int capacity() {
		// Returns the capacity of this StringArray.

		return capacity;
	}

	/**
	 * Method to clear the stringArray
	 */
	public void clear() {
		// Removes all of the Strings from this StringArray.

		stringArray = new String[0];
	}

	/**
	 * Method to check if the Array contains the specified String
	 * 
	 * @param s
	 *            The string whose presence is to be checked
	 * @return returns True if the Array contains the specified String
	 * @throws NullPointerException
	 */
	public boolean contains(String s) throws NullPointerException {
		// Returns true if this StringArray contains the specified String.

		if (s.equals(null)) {
			throw new NullPointerException("String  Null");
		}

		boolean a = false;// local variable a

		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] != null && stringArray[i].equals(s)) {
				a = true;
			}
		}

		return a;
	}

	/**
	 * Method to ensure that the stringArray has the specified capacity
	 * 
	 * @param minCapacity
	 *            0 The minimum capacity the array should have
	 * @throws CapacityOutOfBoundsException
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		// To ensure that it can hold at least the number of Strings specified by the
		// minimum capacity argument.
		if (minCapacity <= size()) {
			throw new CapacityOutOfBoundsException("Capacity not Valid");
		}

		if (capacity >= minCapacity) {
			return;
		}

		else {
			String[] newSA = new String[minCapacity];// making new string array with minimum capacity
			// newSA=NewStringArray

			for (int i = 0; i < size; i++) {
				if (stringArray[i] != null) {
					newSA[i] = stringArray[i];// getting all the values from stringArray to newSA(newStringArray)
				}
			}
			stringArray = newSA;// again making stringArray
		}

	}

	/**
	 * Method to return the String at the specified position
	 * 
	 * @param index
	 *            Index at which the String is to be returned
	 * @return String value at the specified index
	 * @throws IndexOutOfBoundsException
	 */
	public String get(int index) throws IndexOutOfBoundsException {
		// Returns the String at the specified position in this StringArray.
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index not Valid");
		}

		String a = null;// local variable a
		if (index < size) {
			a = stringArray[index];
		}
		return a;
	}

	/**
	 * Method to return the index at which the specified string is present
	 * 
	 * @param s
	 *            String to be checked
	 * @return Index value at which the specified string is present
	 * @throws NullPointerException
	 */
	public int indexOf(String s) throws NullPointerException {
		// Returns the index of the first occurrence of the specified String in this
		// StringArray,
		// or -1 if this StringArray does not contain the String.
		if (s == null) {
			throw new NullPointerException("String is Null");
		}
		int index = -1;
		for (int i = 0; i <= stringArray.length; i++) {
			if (stringArray[i].equals(s))
				;
			index = i;
		}

		return index;
	}

	/**
	 * Method to check if stringArray is empty
	 * 
	 * @return True if the array is empty
	 */
	public boolean isEmpty() {
		// Returns true if this StringArray contains no Strings.
		int a = 0;// local variable a

		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] != null) {
				a++;
			}
		}
		if (a == 0) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * Method to remove the string at specified index position
	 * 
	 * @param index
	 *            Index at which the string is to be removed
	 * @return The removed string value
	 * @throws IndexOutOfBoundsException
	 */
	public String remove(int index) throws IndexOutOfBoundsException {
		// Removes the String at the specified position in this StringArray. Return the
		// String previously at the specified position
		// String newresult = stringArray[index];
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index not Valid");
		}

		// local variable a
		String a = get(index);// calling method 'get' to Return the String previously at the specified
								// position
		stringArray[index] = null;
		ensureCapacity(size - 1);// calling method ensureCapacity
		return a;
	}

	/**
	 * Method to remove the specified string from the array if present
	 * 
	 * @param s
	 *            String to be removed
	 * @return True if the string is removed
	 * @throws NullPointerException
	 */
	public boolean remove(String s) throws NullPointerException {
		// Removes the first occurrence of the specified String from this StringArray,
		// if it is present.
		// Return true if this StringArray contained the specified String.
		if (s.equals(null)) {
			throw new NullPointerException("String  Null");
		}

		boolean a = false;
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] != null && stringArray[i].equals(s)) {
				stringArray[i] = null;
				ensureCapacity(stringArray.length - 1);// calling method'ensureCapacity
				a = true;
			}
		}
		return a;

	}

	/**
	 * Method to assign the specified string at specified index position
	 * 
	 * @param index
	 *            Index Position at which the string is to be appended
	 * @param s
	 *            String to be appended
	 * @return The string previously at the specified position
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException
	 */
	public String set(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		// Replaces the String at the specified position in this StringArray with the
		// specified String.
		// Return the String previously at the specified position. Increases capacity if
		// needed.

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index not Valid");
		}

		String a = null;

		if (index < stringArray.length) {
			a = get(index);/*
							 * calling method 'get' to return the string previously at the specified
							 * position and storing that value in string variable a
							 */
			stringArray[index] = s;
		}
		return a;
	}

	/**
	 * Method to return size of the array
	 * 
	 * @return The size of the array
	 */
	public int size() {
		// Returns the number of Strings in this StringArray.

		return size;
	}

}
