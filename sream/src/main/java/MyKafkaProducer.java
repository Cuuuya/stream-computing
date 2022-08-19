import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyKafkaProducer {
	
	public MyKafkaProducer() {
		Properties pros = new Properties();
		pros.put("bootstrap.servers","localhost:9092");
		pros.put("acks", "all");
		pros.put("retries", 0);
		pros.put("batch.size", 16384);  // 16384byte = 16KB
		pros.put("linger.ms", "10000");
		
		pros.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		pros.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<>(pros);
	}
	
	public boolean send() {
		
	}
	
	public void destroy() {
		
	}

}
