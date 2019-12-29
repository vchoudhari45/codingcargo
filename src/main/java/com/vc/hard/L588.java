package com.vc.hard;

import java.util.*;

class FileSystem {
    static class Dir {
        HashMap<String, Dir> dirs;
        HashMap<String, String> files;

        Dir(HashMap<String, Dir> dirs, HashMap<String, String> files) {
            this.dirs = dirs;
            this.files = files;
        }

        @Override
        public String toString() {
            return "dirs: "+dirs+" files: "+files;
        }
    }

    private Dir root;
    public FileSystem() {
        root = new Dir(new HashMap<String, Dir>(), new HashMap<String, String>());
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<String>();

        String[] pathSplits = path.split("/");
        Dir current = root;
        for(int i = 1; i < pathSplits.length; i++) {
            if(current.dirs.containsKey(pathSplits[i])) current = current.dirs.get(pathSplits[i]);
            else if(current.files.containsKey(pathSplits[i])) {
                res.add(pathSplits[i]);
                return res;
            }
            else {
                return res;
            }
        }

        for(Map.Entry<String, String> files: current.files.entrySet()) {
            res.add(files.getKey());
        }

        for(Map.Entry<String, Dir> dir: current.dirs.entrySet()) {
            res.add(dir.getKey());
        }

        Collections.sort(res, new Comparator<String>() {
            public int compare(String f1, String f2) {
                return f1.compareTo(f2);
            }
        });
        return res;
    }

    public void mkdir(String path) {
        String[] pathSplits = path.split("/");
        Dir current = root;
        for(int i = 1; i < pathSplits.length; i++) {
            if(!current.dirs.containsKey(pathSplits[i])) {
                current.dirs.put(pathSplits[i],
                        new Dir(new HashMap<String, Dir>(), new HashMap<String, String>()));
            }
            current = current.dirs.get(pathSplits[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] pathSplits = filePath.split("/");
        Dir current = root;
        for(int i = 1; i < pathSplits.length - 1; i++) {
            current = current.dirs.get(pathSplits[i]);
        }

        String fileName = pathSplits[pathSplits.length - 1];
        current.files.put(fileName, current.files.getOrDefault(fileName, "") + content);
    }

    public String readContentFromFile(String filePath) {
        String[] pathSplits = filePath.split("/");
        Dir current = root;
        for(int i = 1; i < pathSplits.length - 1; i++) {
            current = current.dirs.get(pathSplits[i]);
        }
        String fileName = pathSplits[pathSplits.length - 1];
        return current.files.getOrDefault(fileName, "");
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
