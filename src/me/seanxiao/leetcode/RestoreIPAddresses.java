package me.seanxiao.leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses obj = new RestoreIPAddresses();
        ArrayList<String> result = obj.restoreIpAddresses("10101010");
        for (String string : result) {
            System.out.println(string);
        }
    }
    
    public ArrayList<String> restoreIpAddresses(String raw) {
        ArrayList<String> ips = new ArrayList<String>();
        if (raw.length() > 12) return ips;
        _solution(raw, "", 0, ips);
        return ips;
    }
    
    public void _solution(String raw, String partial, int part, ArrayList<String> ips) {
        if (raw.equals("") && part == 4) {
            ips.add(partial);
        }
        else if (part != 4 && raw.equals("")) {
            return;
        }
        else {
            if (part != 0) {
                partial += ".";
            }
            for (int i = 1; i <= 3 && i <= raw.length(); i++) {
                String strPart = raw.substring(0, i);
                int ipSubAddress = Integer.parseInt(raw.substring(0, i));
                if (ipSubAddress <= 255 && strPart.equals("" + ipSubAddress)) {
                    _solution(raw.substring(i), partial + ipSubAddress, part + 1, ips);
                }
            }
        }
    }
}
