package Exersice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> info = new TreeMap<>();
        String regexIP = "IP=([0-9.:A-Za-z]+)";
        Pattern patternIP = Pattern.compile(regexIP);
        String regexUser = "user=([\\w]+)";
        Pattern patternUser = Pattern.compile(regexUser);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            Matcher matcher = patternIP.matcher(input);
            Matcher matcher1 = patternUser.matcher(input);

            if (matcher.find() && matcher1.find()) {
                String userName = matcher1.group(1);
                String ip = matcher.group(1);
                info.putIfAbsent(userName, new LinkedHashMap<>());
                info.get(userName).putIfAbsent(ip, 0);
                info.get(userName).put(ip, info.get(userName).get(ip) + 1);
            }

            input = scanner.nextLine();

        }
        for (Map.Entry<String, Map<String, Integer>> user : info.entrySet()) {
            List<String> ipRow = new ArrayList<>();
            System.out.printf("%s:%n", user.getKey());

            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0) {
                System.out.println(".");
            }
        }
    }
}