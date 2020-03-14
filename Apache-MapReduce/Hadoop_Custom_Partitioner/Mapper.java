import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class DepartmentPartitionMapper extends Mapper<Object, Text, Text, Text> {
public Text mapperKey=new Text();
@Override
public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
String data = value.toString();
String[] field = data.split(",", -1);
if (null != field && field.length == 9 && field[3].length() > 0) {
String departmentName = field[3];
mapperKey.set(departmentName);
context.write(mapperKey, value);
}
}
}