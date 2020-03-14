import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable,Text,Text,IntWritable>{
    String line = new String();
    Text firstLetter = new Text();
    IntWritable wordLength = new IntWritable();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        line = value.toString();

        for (String word : line.split("\\W+")){
            if (word.length() > 0) {
                firstLetter.set(String.valueOf(word.charAt(0)));
                wordLength.set(word.length());
                context.write(firstLetter, wordLength);
            }
        }
  }
}
