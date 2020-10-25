/*
 Class: CMSC203 CRN 25800
 Program: Assignment 4
 Instructor: Prof. Grinberg
 Summary of Description: This class creates a plot to be used with other plots as part of the program
 Due Date: 10/25/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student: Andrew Cudd
*/
public class Plot {
	private int x, y, width, depth;

	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	/**
	 * copy constructor
	 * 
	 * @param plot
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}

	/**
	 * constructor with parameters
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * checks if the parameter overlaps the plot
	 * 
	 * @param p
	 * @return true or false
	 */
	public boolean overlaps(Plot p) {
		if (x < p.x + p.width && x + width > p.x && y < p.y + p.depth && y + depth > p.y) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks if the parameter encompasses the plot
	 * 
	 * @param p
	 * @return true or false
	 */
	public boolean encompasses(Plot p) {
		if (((p.x >= x && p.x <= (x + width)) && (p.y >= y && p.y <= (y + depth)))
				&& (((p.x + p.width) >= x && (p.x + p.width) <= (x + width)) && (p.y >= y && p.y <= (y + depth)))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returns x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets x
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * returns y
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets y
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * returns width
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * sets width
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * returns depth
	 * 
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * sets depth
	 * 
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * prints the info of the plot
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		return str;
	}
}
