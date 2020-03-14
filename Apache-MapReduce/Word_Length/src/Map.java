import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


/**
 *
 * @author training
 *TextInputFOrmat is used which will provide key as an offset and line as value
 *From the mapper o/p key is the word and value will be the file name
 */


/*   Mapper Class for Average Word Length problem */

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

                // ---------------------------------------------
                // firstLetter assignment
                firstLetter.set(String.valueOf(word));
                // ---------------------------------------------

                wordLength.set(word.length());
                context.write(firstLetter, wordLength);
            }
        }
  }
}

