
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class Reduce extends Reducer<Text,IntWritable,Text,IntWritable>{

public void reduce(Text Key,Iterable<IntWritable>values,Context output)
       throws IOException,InterruptedException {
         
             int sum =0;
            int count =0;
            int Average =0;
            for(IntWritable val:values) {
                sum += val.get();
                 count = count+1;
                             }
            Average = sum/count;

            output.write(Key,new IntWritable(Average));
}
}
