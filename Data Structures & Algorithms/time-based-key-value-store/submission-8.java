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
        if(values == null) {
            return "";
        }

        int l = 0;
        int r = values.size() - 1;
        while(r - l >= 2) {
            int pivot = l + (r - l) / 2;
            var pivotEl = values.get(pivot);
            if(pivotEl.timestamp > timestamp) {
                r = pivot - 1;
            } else if(pivotEl.timestamp < timestamp) {
                l = pivot;
            } else {
                return pivotEl.value;
            }
        }
        if(values.get(r).timestamp <= timestamp) {
            return values.get(r).value;
        }
        if(values.get(l).timestamp <= timestamp) {
            return values.get(l).value;
        }

        return "";
    }
}
