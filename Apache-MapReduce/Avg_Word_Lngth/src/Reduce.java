import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, DoubleWritable> {

	public void reduce(Text Key, Iterable<IntWritable> values, Context output)
			throws IOException, InterruptedException {

		double sum = 0;
		double count = 0;
		double Average = 0;
		for (IntWritable val : values) {
			sum += val.get();
			count = count + 1;
		}
		Average = sum / count;

		output.write(Key, new DoubleWritable(Average));
	}
}