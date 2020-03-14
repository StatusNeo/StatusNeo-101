import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
public class DepartmentPartitioner extends Partitioner<Text, Text>implements Configurable {
private Configuration conf = null;
@Override
public void setConf(Configuration conf) {
this.conf = conf;
}
@Override
public Configuration getConf() {
return conf;
}
@Override
public int getPartition(Text key, Text value, int numPartitions) {
return Math.abs((key.toString().hashCode()) % numPartitions);
}
}