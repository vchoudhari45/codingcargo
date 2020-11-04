package com.vc.hard;

import java.util.*;

class DesignInMemoryFileSystem {
    static class Dir {
        HashMap<String, Dir> dirs;
        HashMap<String, String> files;

        Dir(HashMap<String, Dir> dirs, HashMap<String, String> files) {
            this.dirs = dirs;
            this.files = files;
        }
    }

    private Dir root;
    public DesignInMemoryFileSystem() {
        this.root = new Dir(new HashMap<>(), new HashMap<>());
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();

        String[] split = path.split("/");
        Dir current = root;
        for(int i = 1; i < split.length; i++) {
            if(current.dirs.containsKey(split[i])) {
                current = current.dirs.get(split[i]);
            }
            else if(current.files.containsKey(split[i])) {
                res.add(split[i]);
                return res;
            }
            else return res;
        }

        for(Map.Entry<String, Dir> entry: current.dirs.entrySet()) {
            res.add(entry.getKey());
        }

        for(Map.Entry<String, String> entry: current.files.entrySet()) {
            res.add(entry.getKey());
        }

        res.sort(new Comparator<String>(){
            public int compare(String path1, String path2) {
                return path1.compareTo(path2);
            }
        });

        return res;
    }

    public void mkdir(String path) {
        String[] split = path.split("/");
        Dir current = root;
        for(int i = 1; i < split.length; i++) {
            if(!current.dirs.containsKey(split[i])) {
                current.dirs.put(split[i],
                        new Dir(new HashMap<String, Dir>(), new HashMap<String, String>()));
            }
            current = current.dirs.get(split[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] split = filePath.split("/");
        Dir current = root;
        for(int i = 1; i < split.length - 1; i++) {
            if(!current.dirs.containsKey(split[i])) {
                current.dirs.put(split[i],
                        new Dir(new HashMap<>(), new HashMap<>()));
            }
            current = current.dirs.get(split[i]);
        }
        String fileName = split[split.length - 1];
        current.files.put(fileName, current.files.getOrDefault(fileName, "") + content);
    }

    public String readContentFromFile(String filePath) {
        String[] split = filePath.split("/");
        Dir current = root;
        for(int i = 1; i < split.length - 1; i++) {
            if(!current.dirs.containsKey(split[i])) return "";
            current = current.dirs.get(split[i]);
        }
        String fileName = split[split.length - 1];
        return current.files.getOrDefault(fileName, "");
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * DesignInMemoryFileSystem obj = new DesignInMemoryFileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */