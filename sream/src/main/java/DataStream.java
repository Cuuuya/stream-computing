public class DataStream {

    //Need to define an abstract data structure to represent infinite data streams
    private int id;
    private String dataType;
    private String dataDescription;
    private String inputMethod;
    private String sampleValue;

    public DataStream(int id, String dataType, String dataDescription, String inputMethod, String sampleValue){
        this.setId(id);
        this.setDataType(dataType);
        this.setDataDescription(dataDescription);
        this.setInputMethod(inputMethod);
        this.setSampleValue(sampleValue);
    }

//    public DataStream getDataStream(int id){
//        return DataStream(id,)
//    }n b

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public void setDataDescription(String dataDescription) {
        this.dataDescription = dataDescription;
    }

    public String getInputMethod() {
        return inputMethod;
    }

    public void setInputMethod(String inputMethod) {
        this.inputMethod = inputMethod;
    }

    public String getSampleValue() {
        return sampleValue;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
    }
}
