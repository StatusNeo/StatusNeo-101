## :memo: Execution:

Step 1:
Make an input file say test.txt and place it into HDFS using this command

```
$ hdfs dfs -put test.txt
```

Step 2:
Run this command 

```
$ hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar -file mapper.py -mapper "python mapper.py" -file reducer.py -reducer "python reducer.py" -input test.txt -output Output1
```

