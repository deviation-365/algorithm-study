public class PG12903 {

    public static void main(String[] args) {
        String result = new PG12903().solution("abcde");
        String result2 = new PG12903().solution("abcdef");
        System.out.println(result);
        System.out.println(result2);
    }

    public String solution(String s) {
        boolean isOdd = s.length() % 2 == 1;
        int middle = s.length() / 2;
        if (isOdd) {
            return s.substring(middle, middle + 1);
        }
        return s.substring(middle - 1, middle + 1);
    }

}
