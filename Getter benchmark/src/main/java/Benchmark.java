import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.time.Duration;
import java.time.Instant;

public class Benchmark {
	int data;
	public int tmp;
	private static final int iterations = 10000000;
	private static final int prime = 9973;

	public Benchmark(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}


	public static void dataBenchmark1(Benchmark benchmark) {
		for (int i=0; i<iterations; i++)
			benchmark.data = benchmark.data % prime;
	}

	public static void dataBenchmark2(Benchmark benchmark) {
		for (int i=0; i<iterations; i++)
			benchmark.setData(benchmark.getData() % prime);
	}



	public static void main(String[] args) throws IOException {
		Benchmark benchmark = new Benchmark(1024);
		Instant start, end;
		Duration duration1, duration2;
		long durationDiff = 0;


		File file = new File("benchmark.csv");
		RandomAccessFile stream = new RandomAccessFile(file, "rw");
		FileChannel channel = stream.getChannel();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		FileLock lock = null;
		try {
			lock = channel.tryLock();
		} catch (final OverlappingFileLockException e) {
			stream.close();
			channel.close();
		}


		bw.write("Direct access" + "," + "Getter/Setter" + "\n");


		for (int i=0; i<100; i++) {
			start = Instant.now();
			for (int j = 0; j < 10; j++)
				dataBenchmark1(benchmark);
			end = Instant.now();
			duration1 = Duration.between(start, end);
			//System.out.println("Direct access: " + Duration.between(start, end));
			bw.write(Duration.between(start, end).toNanos() / 1000000.0 + ",");

			start = Instant.now();
			for (int j = 0; j < 10; j++)
				dataBenchmark2(benchmark);
			end = Instant.now();
			duration2 = Duration.between(start, end);
			//System.out.println("Getter/Setter: " + Duration.between(start, end));
			bw.write(Duration.between(start, end).toNanos() / 1000000.0 + "\n");

			//System.out.println(((duration2.minus(duration1).toNanos() > 0) ? "direct access" : "getter/setter access") + " is faster.");
			//System.out.println("Difference: " + (duration1.minus(duration2).toNanos() / 1000000.0) + "ms = " + (duration1.minus(duration2).toNanos()) + " ns");
			System.out.format("%03d : ", i);
			System.out.println(((duration2.minus(duration1).toNanos() > 0) ? "direct access" : "getter/setter access") + " is faster. "
					+ "Difference: " + (duration1.minus(duration2).toNanos() / 1000000.0) + "ms = " + (duration1.minus(duration2).toNanos()) + " ns");

			durationDiff += duration2.minus(duration1).toNanos();
		}
		System.out.println("Average speed difference: " + durationDiff / 1000000.0 + " ms = " + durationDiff + " ns");

		bw.close();
		lock.release();
		stream.close();
		channel.close();
	}
}
