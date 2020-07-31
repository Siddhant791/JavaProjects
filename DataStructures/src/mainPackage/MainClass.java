package mainPackage;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("s");
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