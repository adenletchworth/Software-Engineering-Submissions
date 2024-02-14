package Entity.FileSystem;
class File {
    private String name;
    private Folder parentFolder;

    File(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
    }

    public void print() {
        System.out.println("File: " + this.name + " (in folder: " + this.parentFolder.getName() + ")");
    }
}
