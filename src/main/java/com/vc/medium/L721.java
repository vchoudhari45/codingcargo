package com.vc.medium;

import java.util.*;

class L721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Email -> Email Mapping
        HashMap<String, HashSet<String>> emails = new HashMap<>();

        //Email -> Account Name Mapping
        HashMap<String, String> name = new HashMap<>();

        for(List<String> account: accounts) {
            String accountName = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                name.put(email, accountName);

                HashSet<String> linked = emails.getOrDefault(email, new HashSet<String>());
                emails.put(email, linked);

                if(i == 1) continue;
                String emailPrev = account.get(i - 1);
                HashSet<String> linkedPrev = emails.getOrDefault(emailPrev, new HashSet<String>());
                linkedPrev.add(email);

                emails.put(emailPrev, linkedPrev);
                emails.get(email).add(emailPrev);
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for(String email: emails.keySet()) {
            if(!visited.contains(email)) {
                //System.out.println("Starting DFS for: "+email);
                List<String> linked = new ArrayList<>();
                dfs(email, linked, emails, visited);
                Collections.sort(linked);
                //System.out.println("--Found linked emails: "+linked);
                linked.add(0, name.get(email));
                res.add(linked);
            }
        }
        return res;
    }

    private void dfs(String email, List<String> linked,
                     HashMap<String, HashSet<String>> emails, HashSet<String> visited) {
        if(visited.contains(email)) return;

        visited.add(email);
        linked.add(email);
        for(String linkedEmail: emails.getOrDefault(email, new HashSet<String>())) {
            dfs(linkedEmail, linked, emails, visited);
        }
    }
}
