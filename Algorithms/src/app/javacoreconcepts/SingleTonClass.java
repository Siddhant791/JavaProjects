package app.javacoreconcepts;

public class SingleTonClass {
	private static volatile SingleTonClass instance;
	private static int n;

	private void setN(int n) {
		this.n = n;
	}

	private SingleTonClass() {
		super();
	}

	public static void color(){
		System.out.println("color");
		System.out.println(this.n);
	}
	public static void main(String[] args) {
		SingleTonClass s1 = new SingleTonClass();
		SingleTonClass s2 = new SingleTonClass();
		s1.setN(1);
		s2.setN(2);
		SingleTonClass.color();
	}

	public SingleTonClass getInstance() {
		if (instance == null) { // t1 , t2 ,t3 , t4 ;
			synchronized (SingleTonClass.class) {
				if (instance == null) { // double check
					instance = new SingleTonClass();
				}
			}
			return new SingleTonClass();
		} else {
			return instance;
		}
	}


}
