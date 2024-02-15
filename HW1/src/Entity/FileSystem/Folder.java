package Entity.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private Folder parentFolder;
    private List<File> files;
    private List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    private Folder(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    public void addSubFolder(String folderName) {
        Folder newFolder = new Folder(folderName, this);
        subFolders.add(newFolder);
    }

    public void addFile(String fileName) {
        File newFile = new File(fileName, this);
        files.add(newFile);
    }

    public Folder getSubFolderByName(String folderName) {
        for (Folder subFolder : subFolders) {
            if (subFolder.getName().equals(folderName)) {
                return subFolder;
            }
        }
        return null;
    }

    public void deleteContents() {
        files.clear();
        for (Folder subFolder : subFolders) {
            subFolder.deleteContents();
        }
        subFolders.clear();
    }

    public void deleteFolder() {
        deleteContents();
        if (this.parentFolder != null) {
            this.parentFolder.subFolders.remove(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void printContents() {
        printContentsHelper("", true);
    }

    private void printContentsHelper(String prefix, boolean isRoot) {
        if (!isRoot) {
            System.out.println(prefix + "Folder: " + name);
        }
        String childPrefix = prefix + "\t";
        for (File file : files) {
            System.out.println(childPrefix + "File: " + file.getName());
        }
        for (Folder subFolder : subFolders) {
            subFolder.printContentsHelper(childPrefix, false);
        }
    }
}
