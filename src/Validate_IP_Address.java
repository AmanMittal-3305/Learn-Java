public class Validate_IP_Address {
    // ---------------- IPV4 CHECK ----------------
    public boolean checkIPv4(String[] p){
        if (p.length != 4) return false;

        for (String part : p) {

            // must not be empty
            if (part.length() == 0) return false;

            // must be max 3 digits, otherwise parseInt will throw
            if (part.length() > 3) return false;

            // no leading zeros (except "0")
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            // must contain only digits
            for (int j = 0; j < part.length(); j++) {
                if (!Character.isDigit(part.charAt(j))) return false;
            }

            // safe parse (now length <= 3 so no exception)
            int n = Integer.parseInt(part);
            if (n < 0 || n > 255) return false;
        }

        return true;
    }

    // ---------------- IPV6 CHECK ----------------
    public boolean checkIPv6(String[] p){
        if (p.length != 8) return false;

        for (String part : p) {
            if (part.length() == 0 || part.length() > 4) return false;

            for (int j = 0; j < part.length(); j++) {
                char c = part.charAt(j);
                boolean ok = (c >= '0' && c <= '9') ||
                        (c >= 'a' && c <= 'f') ||
                        (c >= 'A' && c <= 'F');

                if (!ok) return false;
            }
        }

        return true;
    }

    // ---------------- MAIN FUNCTION ----------------
    public String validIPAddress(String queryIP) {

        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            if (checkIPv4(queryIP.split("\\.", -1))) return "IPv4";
        }

        if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            if (checkIPv6(queryIP.split(":", -1))) return "IPv6";
        }

        return "Neither";
    }
}
