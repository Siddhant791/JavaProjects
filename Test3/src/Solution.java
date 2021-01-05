import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
	}
	
	public static int findAvgItemPriceByType(Item[] itemArray,String inputType) {
		int avg=0;
		int count=0;
		for(Item x:itemArray) {
			if(x.getItemType().toLowerCase().equals(inputType.toLowerCase())) {
				avg+=x.getItemPrice();
				count++;
			}
		}
		if(count!=0) {
			return avg/count;
		}
		return avg;
	}
	
	public static Item[] searchItemByName(String inputName,Item[] itemArray) {
		int size=0;
		for(Item x:itemArray) {
			if(x.getItemName().toLowerCase().equals(inputName.toLowerCase())){
				size++;
			}
		}
		List<Double> temp = new ArrayList<Double>();
		Item[] output = new Item[size];
		for(Item x:itemArray) {
			if(x.getItemName().toLowerCase().equals(inputName.toLowerCase())){
				temp.add(x.getItemPrice());
			}
		}
		Collections.sort(temp);
		int count=0;
		for(Double x:temp) {
			for(Item y:itemArray) {
				if(y.getItemPrice()==x) {
					output[count]=y;
					count++;
				}
			}
		}
		if(output.length==0) {
			return null;
		}
		return output;
	}
}

class Item{
	private int itemId;
	private String itemName;
	private String itemType;
	private double itemPrice;
	public Item(int itemId, String itemName, String itemType, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	
}

//
//1002
//Gulabjam
//Sweet
//800
//1001
//Gulabjam
//Sweet
//700
//1003
//Kalakandi
//Sweet
//1100
//1004
//MoongDal
//Hot
//750
//Sweet
//Gulabjam