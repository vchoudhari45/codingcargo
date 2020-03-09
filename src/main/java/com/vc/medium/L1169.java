package com.vc.medium;

import java.util.*;

class L1169 {
    static class Transaction {
        int time, amount;
        String city;

        Transaction(int time, int amount, String city) {
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return time+","+amount+","+city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String, List<Transaction>> map = new HashMap<>();
        for(String transaction: transactions) {
            String[] splits = transaction.split(",");
            List<Transaction> list = map.getOrDefault(splits[0], new ArrayList<Transaction>());
            list.add(new Transaction(Integer.parseInt(splits[1]), Integer.parseInt(splits[2]), splits[3]));
            map.put(splits[0], list);
        }

        //System.out.println(map);
        HashSet<String> invalid = new HashSet<>();
        for(Map.Entry<String, List<Transaction>> entry: map.entrySet()) {
            String name = entry.getKey();
            List<Transaction> list = entry.getValue();
            for(int i = 0; i < list.size(); i++) {
                Transaction t1 = list.get(i);
                if(t1.amount > 1000) invalid.add(name+","+t1.toString());
                for(int j = 0; j < list.size(); j++) {
                    if(i == j) continue;
                    Transaction t2 = list.get(j);
                    if(Math.abs(t1.time - t2.time) <= 60 && !t1.city.equals(t2.city)) {
                        invalid.add(name+","+t1.toString());
                        invalid.add(name+","+t2.toString());
                    }
                }
            }
        }
        return new ArrayList<>(invalid);
    }
}
