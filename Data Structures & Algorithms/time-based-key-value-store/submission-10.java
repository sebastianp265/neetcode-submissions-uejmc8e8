class TimeMap {

    private final Map<String, List<ValueWithTimestamp>> timeMap;

    private record ValueWithTimestamp(
        String value,
        int timestamp
    ) {
    }

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, (k) -> new ArrayList<>()).add(new ValueWithTimestamp(value, timestamp));
    }

    public String get(String key, int timestamp) {
        var values = timeMap.get(key);
        if (values == null) {
            return "";
        }

        var result = "";

        int l = 0;
        int r = values.size() - 1;
        while (l <= r) {
            int pivot = l + (r - l) / 2;
            var pivotEl = values.get(pivot);
            if (pivotEl.timestamp > timestamp) {
                r = pivot - 1;
            } else {
                result = pivotEl.value;
                l = pivot + 1;
            }
        }
        return result;
    }
}
