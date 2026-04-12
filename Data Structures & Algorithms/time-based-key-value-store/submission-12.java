
class TimeMap {

    private final Map<String, NavigableMap<Integer, String>> timeMap;

    private record ValueWithTimestamp(
        String value,
        int timestamp
    ) {
    }

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, (unused) -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        var values = timeMap.get(key);

        return Optional.ofNullable(values)
            .map(v -> v.floorEntry(timestamp))
            .map(Map.Entry::getValue)
            .orElse("");
    }
}
