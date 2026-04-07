class Solution {

    private final String SEPARATOR = "=";

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length() + SEPARATOR + s);
        }

        System.out.println("ENCODED " + sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for(int i = 0; i < str.length();) {
            char c = str.charAt(i);
            if(c <= '9' && c >= '0') {
                System.out.println("NUMBER " + c);
                sb.append(c);
                i++;
            } else if(c == '=') {
                length = Integer.parseInt(sb.toString());
                sb.setLength(0);
                i++;
                for(int j = 0; j < length; j++) {
                    System.out.println("CHAR " + str.charAt(i + j));
                    sb.append(str.charAt(i + j));
                }
                result.add(sb.toString());
                sb.setLength(0);
                i += length;
            } else {
                throw new RuntimeException();
            }
        }

        return result;
    }
}
