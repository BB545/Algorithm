class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        int sum = 0;
        int len = s.length();

        for (int i = 1; i < len; i++) {
            Character front = s.charAt(i - 1);
            Character back = s.charAt(i);

            if (romans.get(front) < romans.get(back)) {
                sum -= romans.get(front);
            } else {
                sum += romans.get(front);
            }
        }

        return sum + romans.get(s.charAt(len - 1));
    }
}