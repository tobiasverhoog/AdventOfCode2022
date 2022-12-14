package main;

import java.util.HashMap;

public class Dir {
    Dir parent;
    HashMap<String, Dir> dirs = new HashMap<>();
    HashMap<String, Integer> files = new HashMap<>();
    private int sumSizeOfFiles;

    public Dir(Dir parent) {
        this.parent = parent;
    }

    void addFile(String name, int fileSize) {
        sumSizeOfFiles += fileSize;
        files.put(name, fileSize);
    }

    void addDir(String name) {
        dirs.put(name, new Dir(this));
    }

    boolean hasDir(String name) {
        return dirs.containsKey(name);
    }

    Dir getDir(String name) {
        return dirs.get(name);
    }

    int sumSizeOfAllFiles() {
        return dirs.values().stream()
                .map(Dir::sumSizeOfAllFiles)
                .mapToInt(Integer::intValue)
                .sum() + sumSizeOfFiles;
    }

    Dir getParent() {
        return parent;
    }

}
