public class SinearCitizen2678 {

    public static void main(String[] args) {
        String[] ticket = { "9751302862F0693", "3888560693F7262", "5485983835F0649", "2580974299F6042",
                "9976672161M6561", "0234451011F8013", "4294552179O6482" };
        SinearCitizen2678 s = new SinearCitizen2678();
        System.out.println(s.countSeniors(ticket));
    }

    public int countSeniors(String[] details) {
        int count = 0;

        for (int i = 0, n = details.length; i < n; i++) {
            if (checkSenior(details[i])) {
                count++;
            }
        }
        return count;
    }

    private boolean checkSenior(String string) {
        int num = (string.charAt(11) - 48) * 10 + (string.charAt(12) - 48);
        return num > 60;
    }

}
