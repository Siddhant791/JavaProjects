package app.javacoreconcepts;

public class SingleTonClass {
	private static SingleTonClass instance;

	private SingleTonClass() {
	}

	public SingleTonClass getInstance() {
		if (instance == null) {
			return new SingleTonClass();
		} else {
			return instance;
		}
	}
}
