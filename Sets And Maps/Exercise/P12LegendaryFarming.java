package Exersice;

import java.util.*;

public class P12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("motes", 0);
        materials.put("fragments",0);

        String obtainedMaterial = "";
        Map<String, Integer> junk = new TreeMap<>();
        boolean isObtained = false;
        while (!isObtained){
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < input.length - 1; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1];
                if ("motes".equals(material) || "fragments".equals(material) || "shards".equals(material)) {
                    int totalMaterial = materials.get(material) + quantity;
                    materials.put(material, totalMaterial);
                    if (totalMaterial >= 250) {
                        materials.put(material, totalMaterial - 250);
                        obtainedMaterial = material;
                        isObtained = true;
                        break;

                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }

            }
        }
        if (obtainedMaterial.equals("shards")){
            System.out.println("Shadowmourne obtained!");
        }else if (obtainedMaterial.equals("fragments")){
            System.out.println("Valanyr obtained!");
        }else {
            System.out.println("Dragonwrath obtained!");
        }

        materials.entrySet()
                .stream()
                .sorted((a1,a2) ->
                    Integer.compare(a2.getValue(), a1.getValue())
                ).forEach(entry -> System.out.println(entry.getKey()+": " + entry.getValue()));
        junk.forEach((k, v) -> System.out.println(k +": " + v));
    }
}
