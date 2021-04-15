package test5;

public class Employee {
	
	private int basicSalary;
	private int Id;
	private String name;
	private int pay;
	public Employee(int basicSalary, int id, String name) {
		super();
		this.basicSalary = basicSalary;
		Id = id;
		this.name = name;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public void displayPaySlip() {
		 System.out.println("Employee [basicSalary=" + basicSalary + ", Id=" + Id + ", name=" + name + ", pay=" + pay + "]");
	}
	
	public void computePay(String x,int y) {
		if(x.toLowerCase().equals("contractor")) {
			this.pay = this.basicSalary + (y)*75;
		}else if(x.toLowerCase().equals("staff")) {
			this.pay = this.basicSalary - y;
		}
		
	}

	
}
