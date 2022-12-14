package main;

import java.util.ArrayList;
import java.util.List;

public class Day7 {
    public static void main(String[] args) {
        List<String> rows = Utils.readFile("input/InputDay7.txt");

        Dir currentDir = new Dir(null);
        Dir root = currentDir;

        ArrayList<Dir> allDirs = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).equals("$ cd /")) {
                currentDir = root;
            } else if (rows.get(i).equals("$ cd ..")) {
                currentDir = currentDir.getParent();
            } else if (rows.get(i).startsWith("$ cd ")) {
                currentDir = currentDir.getDir(rows.get(i).substring("$ cd ".length()));
            } else if (rows.get(i).equals("$ ls")) {
                while (i + 1 < rows.size() && !rows.get(i + 1).startsWith("$")) {
                    i++;
                    if (rows.get(i).startsWith("dir")) {
                        String dirName = rows.get(i).substring(4);
                        if (!currentDir.hasDir(dirName)) {
                            currentDir.addDir(dirName);
                            allDirs.add(currentDir.getDir(dirName));
                        }
                    } else {
                        int fileSize = Integer.parseInt(rows.get(i).split(" ")[0]);
                        String fileName = rows.get(i).split(" ")[1];
                        currentDir.addFile(fileName, fileSize);
                    }

                }
            }
        }

        long total = 0L;
        for (Dir dir :
                allDirs) {
            int sum = dir.sumSizeOfAllFiles();
            if (sum <= 100000) {
                total += sum;
            }
        }
        System.out.println("Answer 1: " + total);


        long spaceUsed = root.sumSizeOfAllFiles();
        long spaceFree = 70000000 - spaceUsed;
        long spaceNeeded = 30000000 - spaceFree;
        Dir answer = null;
        for (Dir f : allDirs) {
            int sum = f.sumSizeOfAllFiles();
            if (sum >= spaceNeeded && (answer == null || sum <= answer.sumSizeOfAllFiles())) {
                answer = f;
            }
        }
        System.out.println("Answer 2: " + answer.sumSizeOfAllFiles());
    }
}