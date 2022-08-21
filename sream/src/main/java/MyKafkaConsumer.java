import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyKafkaConsumer {
	
	private final KafkaConsumer<String, String> consumer;
	private static final Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);
	
	public MyKafkaConsumer() {
		Properties pros = new Properties();
		pros.setProperty("bootstrap.servers", "localhost:9092");
		pros.setProperty("group.id", "test"); // different group can consume repeatedly
		pros.setProperty("enable.auto.commit", "true");
		pros.setProperty("auto.commit.interval.ms", "1000");
		pros.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		pros.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		this.consumer = new KafkaConsumer<>(pros);
	}

}
