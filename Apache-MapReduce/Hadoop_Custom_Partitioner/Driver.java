import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import com.hadoop.design.summarization.blog.ConfigurationFactory;
public class DriverCustomPartioner {
public static void main(String[] args) throws Exception {
/*
* I have used my local path in windows change the path as per your
* local machine
*/
args = new String[] { "Replace this string with Input Path location",
"Replace this string with output Path location" };
/* delete the output directory before running the job */
FileUtils.deleteDirectory(new File(args[1]));
/* set the hadoop system parameter */
System.setProperty("hadoop.home.dir", "Replace this string with hadoop home directory location");
if (args.length != 2) {
System.err.println("Please specify the input and output path");
System.exit(-1);
}
Configuration conf = new Configuration();
Job job = Job.getInstance(conf);
job.setPartitionerClass(DepartmentPartitioner.class);
job.setJarByClass(DriverCustomPartioner.class);
job.setJobName("Partioning_Pattern");
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
job.setMapperClass(DepartmentPartitionMapper.class);
job.setReducerClass(PartitionerReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);
job.setNumReduceTasks(38);
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
