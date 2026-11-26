class Solution {

    private final String[] below20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();

        int billion = num / 1000000000;
        int million = (num % 1000000000) / 1000000;
        int thousand = (num % 1000000) / 1000;
        int rest = num % 1000;

        if (billion != 0) {
            sb.append(helper(billion)).append(" Billion");
        }

        if (million != 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(helper(million)).append(" Million");
        }

        if (thousand != 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(helper(thousand)).append(" Thousand");
        }

        if (rest != 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(helper(rest));
        }

        return sb.toString();
    }

    private String helper(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num];
        }

        if (num < 100) {
            return tens[num / 10]
                    + (num % 10 != 0 ? " " + helper(num % 10) : "");
        }

        return below20[num / 100]
                + " Hundred"
                + (num % 100 != 0 ? " " + helper(num % 100) : "");
    }
}
