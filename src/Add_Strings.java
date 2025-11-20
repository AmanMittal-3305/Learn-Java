public class Add_Strings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;  // last index
        int j = num2.length() - 1;  // last index
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0 || carry != 0){
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;

            sb.append(sum % 10);  // append last digit

            i--;
            j--;
        }

        return sb.reverse().toString();  // reverse at end
    }
}
