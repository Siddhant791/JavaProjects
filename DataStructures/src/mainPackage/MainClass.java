package mainPackage;

import linkedList.LinkedList;
import stack.Stack;

public class MainClass {
 
	public static void main(String[] args) throws Exception {
		
		LinkedList<Integer> ll = new LinkedList();
		Stack<Integer> myStack = new Stack<Integer>();
		java.util.LinkedList<Integer> lw = new java.util.LinkedList<Integer>();
		myStack.push(12);
		myStack.push(15);
		myStack.pop();
		myStack.push(45);
		myStack.push(123);
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.peek());
	}

}
class Mobile
{
  private String iMEICode;
  private boolean isSingleSIM;
  private String processor;
  private double price;
  private String manufacturer;
  
  
public Mobile(String iMEICode, boolean isSingleSIM, String processor, double price, String manufacturer) {
	super();
	this.iMEICode = iMEICode;
	this.isSingleSIM = isSingleSIM;
	this.processor = processor;
	this.price = price;
	this.manufacturer = manufacturer;
}
public String getiMEICode() {
	return iMEICode;
}
public void setiMEICode(String iMEICode) {
	this.iMEICode = iMEICode;
}
public boolean isSingleSIM() {
	return isSingleSIM;
}
public void setSingleSIM(boolean isSingleSIM) {
	this.isSingleSIM = isSingleSIM;
}
public String getProcessor() {
	return processor;
}
public void setProcessor(String processor) {
	this.processor = processor;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
  
  
}