import kafka.MyKafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

import java.io.FileWriter;


public class Operators {

    public DataStream source(String topic){
        // Get data from kafka for a specific topic
        MyKafkaConsumer consumerFactory = new MyKafkaConsumer(topic);
        KafkaConsumer consumer = consumerFactory.getConsumer();
        // Store data into DataStream structure
        DataStream dataStream = new DataStream();
        while (true) {
            try {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record: records) {
                    dataStream.addRecord(record.key(), record.value());
                }
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        consumerFactory.destroy();
        return dataStream;
    }

    public static void sink(DataStream dataStream) throws IOException {
        Queue<SingleStream> q = dataStream.getQueue();
        FileWriter fWriter = new FileWriter("test.txt");

        for (SingleStream data: q){
            String s = "Key: " + data.getKey() + " " + "Value: " + data.getValue() + "\n";
            fWriter.write(s);
        }

        fWriter.close();

    }

    public DataStream map(DataStream dataStream){
        DataStream mappedStream = new DataStream();
        Queue<SingleStream> q = dataStream.getQueue();

        while (! q.isEmpty()){
            SingleStream s = q.poll();
            // some map processing
            mappedStream.addRecord(s.getKey(), s.getValue());
        }
        return  mappedStream;
    }

    public  DataStream keyBy(DataStream mappedStream){
        DataStream keyByDataStream = new DataStream();
        Queue<SingleStream> q = mappedStream.getQueue();

        while (!q.isEmpty()){
            SingleStream currentData = q.poll();
            ArrayList<Object> values = new ArrayList<>();
            values.add(currentData.getValue());
            for (SingleStream data: q){
                if (data.getKey() == currentData.getKey()){
                    values.add(data.getValue());
                    q.remove(data);
                }
            }
            keyByDataStream.addRecord(currentData.getKey(), values);
        }
        return  keyByDataStream;
    }

    public  DataStream reduce(DataStream keyByDataStream){
        DataStream reducedDataStream = new DataStream();
        Queue<SingleStream> q = keyByDataStream.getQueue();

        while(!q.isEmpty()){
            SingleStream currentData = q.poll();
            currentData.setValue(Arrays.stream((double[]) currentData.getValue()).sum());

            reducedDataStream.addRecord(currentData.getKey(), currentData.getValue());

        }
        return reducedDataStream;
    }
}
