import java.util.*;

public class DataStream {

    public Queue<SingleStream> mq;

    public void addRecord( String key, Object value) {
        SingleStream singleStream = new SingleStream(key, value);
        mq.add(singleStream);
    }

    public Queue<SingleStream> getQueue() {
        return  mq;
    }
}

class SingleStream {
//    private long offset;
    private String key;
    private Object value;

    public SingleStream(String key, Object value) {
//        this.offset = offset;
        this.key = key;
        this.value = value;
    }

    public SingleStream() {

    }

//    public void setOffset(long offset) {
//        this.offset = offset;
//    }
//
//    public long getOffset() {
//        return offset;
//    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
