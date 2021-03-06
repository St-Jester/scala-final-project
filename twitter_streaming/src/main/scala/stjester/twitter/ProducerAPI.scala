package stjester.twitter

import java.util.Properties

import org.apache.kafka.clients.producer._

class Producer {

  def writeToKafka(topic: String, data:String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String](topic, "key", data)
    producer.send(record)
    producer.close()
  }
}

object send extends App{
  val producer = new Producer()
  producer.writeToKafka("twitter", "testvalue")
}


