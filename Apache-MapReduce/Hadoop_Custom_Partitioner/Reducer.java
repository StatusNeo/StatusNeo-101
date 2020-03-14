import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class PartitionerReducer extends Reducer<Text, Text, Text, NullWritable> {
@Override
public void reduce(Text text, Iterable<Text> values, Context context) throws IOException, InterruptedException {
for (Text value : values) {
context.write(value, NullWritable.get());
}
}
}