public class Operators {

    public DataStream source(DataStream dataStream){
//        get data from kafka and output datastreams
        return dataStream;
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
