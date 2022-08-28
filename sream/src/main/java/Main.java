import kafka.MyKafkaProducer;
import kafka.MyKafkaConsumer;

public class Main {
    public static void main(String[] args) {
        MyKafkaProducer producer = new MyKafkaProducer();
        producer.send_data("topic1", "berry");
        producer.destroy();
//        MyKafkaConsumer consumer = new MyKafkaConsumer("topic1");
//        consumer.get_data();
//        consumer.destroy();


    }
}
