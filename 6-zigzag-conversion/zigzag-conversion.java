class Solution {
    public String convert(String s, int numRows) {
        // Edge case: agar numRows 1 hai ya string length se bada hai
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Har row ke liye StringBuilder banate hain
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Characters ko zigzag mein distribute karna
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Direction change karna jab top/bottom row pe ho
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Row increment/decrement
            currentRow += goingDown ? 1 : -1;
        }

        // Final result concatenate karna
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }
}
