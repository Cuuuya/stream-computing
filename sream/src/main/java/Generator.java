public class Generator {
    public String topic;
    public String data;

    public static void generate(String topic, String data){
        MyKafkaProducer producer = new MyKafkaProducer();
        producer.send_data(topic, data);
        producer.destroy();
    }

}
