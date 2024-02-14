package Entity.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files;
    private List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    public void addSubFolder(String folderName) {
        Folder newFolder = new Folder(folderName);
        subFolders.add(newFolder);
    }

    public void addFile(String fileName) {
        File newFile = new File(fileName, this);
        files.add(newFile);
    }

    public void deleteContents() {
        files.clear();
        for (Folder subFolder : subFolders) {
            subFolder.deleteContents(); 
        }
        subFolders.clear();
    }

    public String getName() {
        return this.name;
    }
    
}
