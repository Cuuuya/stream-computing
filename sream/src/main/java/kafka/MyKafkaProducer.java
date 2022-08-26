package kafka;
import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyKafkaProducer {
	
	private final Producer<String, String> producer;
	private static final Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);
	
	public MyKafkaProducer() {
		Properties pros = new Properties();
		pros.put("bootstrap.servers","localhost:9092"); // address of Kafka
		pros.put("acks", "all"); // information acknowledgement
		pros.put("retries", 0); // no re-send
		pros.put("batch.size", 16384);  // 16384byte = 16KB
		pros.put("linger.ms", "10000");
		
		pros.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		pros.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		//Producer<Integer, String> producer = new KafkaProducer<>(pros);
		// a Kafka client that publishes records to the Kafka cluster
		this.producer = new KafkaProducer<>(pros);
	}
	
	public void send_data(String topic, String data) {
		try {
			for (int i = 0; i < 100; i++) {
				// key/value pairs
				producer.send(new ProducerRecord<String, String>(topic, Integer.toString(i), data));
			}
		} catch (Exception e) {
			logger.error(String.format("Topic:[%s], data:[%s], ", topic, data) + e);
		}
	}
	
	public void destroy() {
		
		if (producer != null) {
			producer.close();
		}
	}

}
