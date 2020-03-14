import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class Driver extends Configured implements Tool {

 public static void main(String[] args) throws Exception
 {

   ToolRunner.run(new Driver(), args);
 }

 @Override
 public int run(String[] args) throws Exception
 {

  /*   Driver Class for Word Co-occurence problem */
  Job job=new Job(getConf(),"KP Word Cooccurence Job");
  job.setJarByClass(Driver.class);

  job.setMapperClass(Map.class);
  job.setReducerClass(Reduce.class);
/* job.setNumReduceTasks(0);  */
  job.setInputFormatClass(TextInputFormat.class);

  job.setMapOutputKeyClass(Text.class);
  job.setMapOutputValueClass(IntWritable.class);

  job.setOutputKeyClass(Text.class);
  job.setOutputValueClass(DoubleWritable.class);

  FileInputFormat.addInputPath(job,new Path(args[0]));
  FileOutputFormat.setOutputPath(job,new Path(args[1]));

  job.waitForCompletion(true);
  return 0;
 }
}