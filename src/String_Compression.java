public class String_Compression {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int k = 0; // write pointer

        while (i < n) {
            char current = chars[i];
            int count = 0;

            // count occurrences of current char
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write the character
            chars[k++] = current;

            // write the count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[k++] = c;
                }
            }
        }

        return k; // new length
    }
}
