
class TimeMap {

    private final Map<String, List<ValueWithTimestamp>> keyToValueWithTimestamp;

    private record ValueWithTimestamp(
            String value,
            int timestamp
    ) {

    }

    public TimeMap() {
        keyToValueWithTimestamp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyToValueWithTimestamp.compute(key, (k, valueWithTimestamps) ->{
            var valToAdd = new ValueWithTimestamp(value, timestamp);
            if(valueWithTimestamps == null) {
                return new ArrayList<>(List.of(valToAdd));
            } else {
                valueWithTimestamps.add(valToAdd);
                return valueWithTimestamps;
            }
        });
    }

    public String get(String key, int timestamp) {
        var valuesWithTimestamps = keyToValueWithTimestamp.get(key);
        if(valuesWithTimestamps == null) {
            return "";
        }
        for(var valueWithTimestamp : valuesWithTimestamps.reversed()) {
            if(valueWithTimestamp.timestamp <= timestamp) {
                return valueWithTimestamp.value;
            }
        }

        return "";
    }
}
