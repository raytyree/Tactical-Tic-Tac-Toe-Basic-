package arrays;
/**
 * @author Raymon Tyree
 *
 */
public class ArrayTools {
	/**
	 * Creates String listing the objects in a list
	 * @param <T> - Generic type inserted
	 * @param array - the array to be converted to a string
	 * @return a string composed of the elements in an array
	 */
	public static <T>String printArray(Object[] array){
		String out = "{";
		for(Object arr : array) {
			if (arr != null) {
				out += arr.toString() + ", ";
			}
			else {
				out += ("null, ");
			}
		}
		out = out.substring(0, out.length()-2);
		out += "}";
		return out;
	}
	/**
	 * Finds the first instance of a desired object in an array
	 * @param <T> - Generic Type inserted
	 * @param array - The array to be searched
	 * @param seek - The object being found
	 * @return - the index of the element if found else return -1
	 */
	public static <T>int findElement(Object[] array, Object seek){
		int out = -1;
		int i = 0;
		if(array == null) {
			System.out.println("ERROR: Array is null");
			return out;
		}
		if(array.length == 0) {
			System.out.println("ERROR: List is empty");
			return out;
		}
		for(Object arr : array) {
			if(arr == null){
				System.out.print(String.format("Error: Element at index %d is NULL", array));
				return out;
			}
			if(arr.equals(seek)){
				out = i;
				return out;
			}
			else if(i >= array.length) {
				System.out.println("ERROR: Object is not in list");
				return out;
			} else {
				i++;
			}
		}
		return out;
	}
	/**
	 * Fills an array with an element of choice
	 * @param <T> - Generic Type inserted
	 * @param array - The array to be searched
	 * @param filler - The object to fill the array
	 * @return The array with the filled elements
	 */
	public static <T>Object[] fillArray(Object[] array, Object filler){
		Object [] out = null;
		if(array == null){
			System.out.print(String.format("Error: Element at index %d is NULL", array));
			return out;
		}
		if(array.length == 0) {
			System.out.println("ERROR: List is empty");
			return out;
		}
		out = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			out[i] = filler;
		}
		return out;
	}
}
