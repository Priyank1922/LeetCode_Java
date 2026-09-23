class Solution {
    public String intToRoman(int num) {
        // Define Roman numeral symbols and their corresponding values
        int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40,  10, 9,   5,  4,  1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L", "XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        // Loop through each symbol, stopping when num becomes 0
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}