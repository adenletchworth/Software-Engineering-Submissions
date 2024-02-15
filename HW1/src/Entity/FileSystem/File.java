package Entity.FileSystem;
class File {
    private String name;
    private Folder parentFolder;

    File(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public void print() {
        System.out.println("File: " + this.name + " (in folder: " + this.parentFolder.getName() + ")");
    }
}
