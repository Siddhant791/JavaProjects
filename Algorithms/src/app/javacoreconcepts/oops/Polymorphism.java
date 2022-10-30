package app.javacoreconcepts.oops;

public class Polymorphism {
	
	public Integer getDouble(Integer input) {
		return input*2;
	}
	
	public Double getDouble(Double input) {
		return input*2;
	}
	
	public Number getDouble(Number input) {
		if(input instanceof Integer) {
			System.out.println("in integer");
			return (Integer)input*2;			
		}else if(input instanceof Double) {
			System.out.println("in double");
			return (Double)input*2;
		}else {
			return null;
		}
	}
	
}
