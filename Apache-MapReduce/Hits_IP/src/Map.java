import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map
       extends Mapper<LongWritable, Text, Text, IntWritable>{
	
    //private final static IntWritable one = new IntWritable(1);
    //private Text word = new Text();

    public void map(LongWritable key, Text value, Context context
                    ) throws IOException, InterruptedException {
      String ip = value.toString(); 
      
      String hits = ip.substring(0,ip.indexOf(' ')).trim();
      //Tokenizer itr = new StringTokenizer(value.toString());
      //while (itr.hasMoreTokens()) {
        //word.set(itr.nextToken());
      int len = hits.length();
      
      if(len>0){
      context.write(new Text(hits), new IntWritable(1));
      }
    }
  }