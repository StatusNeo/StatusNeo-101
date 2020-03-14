# :memo: Disk_Based_Processing_MapReduce

In Disk Based processing we learn to use various Bigdata tools for example: MapReduce,Yarn.. 

## :grey_question: Pre-Requisites to run Mapreduce Programs:

- Pre-configured Cloudera Quistart VM

	- With Minimum 8 Gb Ram
	- 4 Cpu
	
## :computer: Here are the basic implementations of Mapreduce Programs:
  ## 1. [Word Count Program](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/WordCount) :
  
We will count the no. of words in a file(in HDFS) and no of occurences we get will be stored in a seperate file in HDFS < [name of Output dir mentioned in command]/part* >  

  ## 2. [Word Count Program Using Tool Runner](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/WordCount_Using_ToolRunner) :
We will count the no. of words/occuraces of word in a file using a special function ToolRunner(in HDFS)and the file we getas output will be stored in HDFS < [name of Output dir mentioned in command]/part* >  

  ## 3. [Char_Count](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Char_Count) :
No. of occurances per charachter including all speccial charachters will be counted and stored in a file < [name of Output dir mentioned in command]/part* >  

  ## 4. [Word_Length](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Word_Length) :
Length of each unique word will be counted and stored in output file in HDFS < [name of Output dir mentioned in command]/part* > 

  ## 5. [Avg_Word_Length](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Avg_Word_Lngth) :
Average Length of each unique word on the basis of thier first letter will be counted and stored in output file in HDFS < [name of Output dir mentioned in command]/part* > 

For example- if we have two word in a file named Hadoop and Hive then the output will be 

        hadoop - 6 and hive - 4 => 6+4 => 10/no.of words
        output =>  h    5 
	
  ## 6. [No. of Hits per IP Address](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Hits_IP) :
Number of Hits on each unique IP Address on the basis of weblogs will be counted and stored in output file in HDFS < [name of Output dir mentioned in command]/part* > 

  ## 7. [WordCount Using Combiner Class](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/WordCountUsingCombinerClass) :
  A new Class is added in Driver code of the program making execution fast :innocent:
  Combiner class gets executed just after mapping phase and aggregates the data to help reducer in faster execution.
  ## 8. [MRUnit Testing the MapReduce Code](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/MRUnit) :
  Just like there is a testing tool in java "JUNIT" there is "MRUnit" in MapReduce to test whether the code is running properly or not. We can test code by passing sample inputs and check the outputs.  
  ## 9. [Exploring Yarn And HUE](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Exploring_Yarn_And_Hue) :
  Hadoop offers a UI tool for getting a UI expirience i.e HUE. We will bw exploring HUE using some Screenshots.
  ## 10. [Hadoop Streaming](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Hadoop_Streaming_Python) :
  Hadoop Mapreduce is not limited to java it also supports various programming language like python perl and many other languages with the help of hadoop streaming libraries. 
  ## 11. [Hadoop Log Processing](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Hadoop_Log_Processing) :
  Since it is a Map only task it includes only mapper and a driver to process access logs. It finds theno of Hits per Image format on a particular site.
  ## 12. [Hadoop Custom Partitoner](https://github.com/priyansh19/Disk_Based_Processing_MapReduce/tree/master/Hadoop_Custom_Partitioner) :
  Implementing a custom partitioner helps us customising partitoners according to the requirement of the user and storing customised data in different Reducers.
# :rainbow: Commands to trigger MapReduce programs:

## Prerequisites:
  1. Make sure the .jar file should be placed in the same directory in which your terminal is running
  2. place the input file into HDFS by following command
  ```shell
  hdfs dfs -put <input.file name>
  ```
## Command to run map and reduce tasks on input file:

```shell
hadoop jar <JAR NAME>.jar <CLASS NAME> <INPUT FILE NAME>.txt <OUTPUT DIR NAME>
```
```
JAR NAME : Name of the .jar file exported after writing code
CLASS NAME : Name of Driver Class of MapReduce Program
INPUT FILE NAME : Name of Input file we placed in hdfs
OUTPUT DIR NAME : Name of Output directory to be created
```
## If your program runs successfully then you will find it like this :
```
19/09/13 02:48:59 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
19/09/13 02:48:59 INFO input.FileInputFormat: Total input paths to process : 1
19/09/13 02:48:59 WARN hdfs.DFSClient: Caught exception 
java.lang.InterruptedException
	at java.lang.Object.wait(Native Method)
	at java.lang.Thread.join(Thread.java:1281)
	at java.lang.Thread.join(Thread.java:1355)
	at org.apache.hadoop.hdfs.DFSOutputStream$DataStreamer.closeResponder(DFSOutputStream.java:967)
	at org.apache.hadoop.hdfs.DFSOutputStream$DataStreamer.endBlock(DFSOutputStream.java:705)
	at org.apache.hadoop.hdfs.DFSOutputStream$DataStreamer.run(DFSOutputStream.java:894)
19/09/13 02:48:59 INFO mapreduce.JobSubmitter: number of splits:1
19/09/13 02:48:59 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1568355876268_0005
19/09/13 02:49:00 INFO impl.YarnClientImpl: Submitted application application_1568355876268_0005
19/09/13 02:49:00 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1568355876268_0005/
19/09/13 02:49:00 INFO mapreduce.Job: Running job: job_1568355876268_0005
19/09/13 02:49:06 INFO mapreduce.Job: Job job_1568355876268_0005 running in uber mode : false
19/09/13 02:49:06 INFO mapreduce.Job:  map 0% reduce 0%
19/09/13 02:49:11 INFO mapreduce.Job:  map 100% reduce 0%
19/09/13 02:49:17 INFO mapreduce.Job:  map 100% reduce 100%
19/09/13 02:49:17 INFO mapreduce.Job: Job job_1568355876268_0005 completed successfully
19/09/13 02:49:17 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=94
		FILE: Number of bytes written=288031
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=187
		HDFS: Number of bytes written=56
		HDFS: Number of read operations=6
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=3075
		Total time spent by all reduces in occupied slots (ms)=3318
		Total time spent by all map tasks (ms)=3075
		Total time spent by all reduce tasks (ms)=3318
		Total vcore-milliseconds taken by all map tasks=3075
		Total vcore-milliseconds taken by all reduce tasks=3318
		Total megabyte-milliseconds taken by all map tasks=3148800
		Total megabyte-milliseconds taken by all reduce tasks=3397632
	Map-Reduce Framework
		Map input records=11
		Map output records=11
		Map output bytes=66
		Map output materialized bytes=94
		Input split bytes=121
		Combine input records=0
		Combine output records=0
		Reduce input groups=7
		Reduce shuffle bytes=94
		Reduce input records=11
		Reduce output records=7
		Spilled Records=22
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=89
		CPU time spent (ms)=870
		Physical memory (bytes) snapshot=435740672
		Virtual memory (bytes) snapshot=3015176192
		Total committed heap usage (bytes)=418385920
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=66
	File Output Format Counters 
		Bytes Written=56
```
## How to check your output ?

To check your output type 
```shell 
hdfs dfs -cat <OUTPUT DIR NAME>/part*
```
it will take few seconds to execute and then display your output file contents
