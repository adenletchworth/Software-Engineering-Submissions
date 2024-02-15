import Entity.FileSystem.Folder;

public class FileSystemDriver {
    public static void main(String[] args) {

        Folder phpDemoFolder = new Folder("php_demo1");
        phpDemoFolder.addSubFolder("Remote Files");
        phpDemoFolder.addSubFolder("Source Files");
        phpDemoFolder.addSubFolder("Include Path");

        Folder sourceFilesFolder = phpDemoFolder.getSubFolderByName("Source Files");
        sourceFilesFolder.addSubFolder(".phalcon");
        sourceFilesFolder.addSubFolder("app");
        sourceFilesFolder.addSubFolder("public");
        sourceFilesFolder.addSubFolder("cache");

        Folder appFolder = sourceFilesFolder.getSubFolderByName("app");
        appFolder.addSubFolder("config");
        appFolder.addSubFolder("controllers");
        appFolder.addSubFolder("library");
        appFolder.addSubFolder("migrations");
        appFolder.addSubFolder("models");
        appFolder.addSubFolder("views");

        Folder publicFolder = sourceFilesFolder.getSubFolderByName("public");
        publicFolder.addFile(".htaccess");
        publicFolder.addFile("index.html");
        publicFolder.addFile(".htrouter.php");

        phpDemoFolder.printContents();
        appFolder.deleteFolder();
        phpDemoFolder.printContents();
        publicFolder.deleteFolder();
        phpDemoFolder.printContents();
    }
    
}
