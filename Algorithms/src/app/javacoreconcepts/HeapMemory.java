package app.javacoreconcepts;

//driver class
class HeapMemory {

	// main method
	public static void getHeapSize()
	{
		double mb = 1000000;

		// creating runtime time object
		Runtime r = Runtime.getRuntime();

		// displaying max memory of heap in Mb
		System.out.println("Max memory"
						+ " " + r.maxMemory() / mb);

		// displaying initial memory in Mb
		System.out.println("Initial memory"
						+ " " + r.totalMemory() / mb);

		// displaying free memory in Mb
		System.out.println("Free memory"
						+ " " + r.freeMemory() / mb);

		// displaying consume memory in Mb
		System.out.println(
			"Consume memory"
			+ " "
			+ (r.totalMemory() - r.freeMemory()) / mb);
	}
}
