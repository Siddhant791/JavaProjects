package test2.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
public class MainClass {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello");
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		Solution.merge(nums1,3,nums2,3);
	}
}

class Comp implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1>o2) {
			return 1;
		}
		return -1;
	}

}
		
//	public static void saveRecord(String Id,String filePath) throws IOException {
//		FileWriter fw=new FileWriter(filePath, true);
//		BufferedWriter bw=new BufferedWriter(fw);
//		PrintWriter pw=new PrintWriter(bw);
//
//		pw.println(Id+","+"hello");
//		pw.flush();
//		pw.close();
//		System.out.println("k");
//	}
//}
//class People
//{
//  public int wardNo;
//  public String personName;
//  public int age;
//  public String village;
//  public String Taluk;
//public People(int wardNo, String personName, int age, String village, String taluk) {
//	super();
//	this.wardNo = wardNo;
//	this.personName = personName;
//	this.age = age;
//	this.village = village;
//	Taluk = taluk;
//}
//public int getWardNo() {
//	return wardNo;
//}
//public void setWardNo(int wardNo) {
//	this.wardNo = wardNo;
//}
//public String getPersonName() {
//	return personName;
//}
//public void setPersonName(String personName) {
//	this.personName = personName;
//}
//public int getAge() {
//	return age;
//}
//public void setAge(int age) {
//	this.age = age;
//}
//public String getVillage() {
//	return village;
//}
//public void setVillage(String village) {
//	this.village = village;
//}
//public String getTaluk() {
//	return Taluk;
//}
//public void setTaluk(String taluk) {
//	Taluk = taluk;
//}
//
//
//}

class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0){
			nums1=nums2;
		}
		if (n == 0){
			return;
		}

		int[] output = new int[m+n];
		int i = 0;
		int j = 0;
		int count = 0;

		while (i<m && j<n){
			if (nums1[i] <= nums2[j]){
				output[count] = nums1[i];
				i++;
			}
			else {
				output[count] = nums2[j];
				j++;
			}
			count++;
		}

		while(i<m){
			output[count] = nums1[i];
			i++;
			count++;
		}

		while(j<n){
			output[count] = nums2[j];
			j++;
			count++;
		}
		System.out.println(output[1]);
		nums1 = output;
		System.out.println(Arrays.toString(nums1));
	}
}