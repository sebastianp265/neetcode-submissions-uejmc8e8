class TimeMap {

    private final Map<String, NavigableSet<ValueWithTimestamp>> timeMap;

    private record ValueWithTimestamp(
        String value,
        int timestamp
    ) {
    }

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, (k) -> new TreeSet<>(Comparator.comparingInt(ValueWithTimestamp::timestamp)))
            .add(new ValueWithTimestamp(value, timestamp));
    }

    public String get(String key, int timestamp) {
        var values = timeMap.get(key);
        if (values == null) {
            return "";
        }

        return Optional.ofNullable(values.floor(new ValueWithTimestamp("", timestamp)))
            .map(ValueWithTimestamp::value)
            .orElse("");
    }
}
