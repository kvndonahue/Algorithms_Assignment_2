package util;

public interface SerializerAPI {

	/**
	 * Pushes the object onto a stack
	 * @param o
	 */
	void push(Object o);

	/**
	 * Pops the top object off the stack
	 * @return
	 */
	Object pop();

	/**
	 * Writes the stack to XML
	 * @throws Exception
	 */
	void write() throws Exception;

	/**
	 * Reads the stack from XML
	 * @throws Exception
	 */
	void read() throws Exception;
}
