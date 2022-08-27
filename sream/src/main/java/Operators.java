public class Operators {

    public DataStream source(String topic){
//        get data from kafka and output datastreams
        MyKafkaConsumer consumer = new MyKafkaConsumer();
        consumer.subscribe(topic);
        return null;
    }

    public static void sink(DataStream dataStream){
//        output a file
    }

    public DataStream map(DataStream dataStream){
//        map processing
        return  dataStream;
    }

    public  DataStream keyBy(DataStream dataStream){
//        operations according to key
        return  dataStream;
    }

    public  DataStream reduce(DataStream dataStream){
//        reduce operation
        return dataStream;
    }
}
