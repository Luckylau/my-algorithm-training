package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/1/31
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(Arrays.toString(restoreIpAddresses.restoreIpAddresses("2551234").toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return addresses;
        }
        StringBuilder sb = new StringBuilder();
        reStore(sb, addresses, 0, s);
        return addresses;
    }

    private void reStore(StringBuilder sb, List<String> addresses, int count, String s) {
        if (count == 4 || s.length() == 0) {
            if (count == 4 && s.length() == 0) {
                addresses.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (sb.length() != 0) {
                    part = "." + part;
                }
                sb.append(part);
                reStore(sb, addresses, count + 1, s.substring(i + 1));
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }
    }
}
