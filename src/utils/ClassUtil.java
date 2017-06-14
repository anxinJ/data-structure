package utils;

import simple.sort.SortBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by hewj on 17/6/13.
 */
public class ClassUtil {

    public static List<Class> getSubClassesByParent(Class parent){
        List<Class> ret = new ArrayList<>();
        String packageName = parent.getPackage().getName();
        List<Class> allClasses = null;
        try {
            allClasses = getClass(packageName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(allClasses != null){
            allClasses.stream().forEach(clazz -> {
                if(!clazz.equals(parent) && clazz.getSuperclass().equals(parent)){
                    ret.add(clazz);
                }
            });
        }
        return ret;
    }



    private static List getClass(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if(!directory.exists()){
            return classes;
        }
        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            }else if(file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName + "." +file.getName().substring(0, file.getName().length()-6)));
            }
        }
        return classes;
    }

    public static void main(String[] args){
        getSubClassesByParent(SortBase.class);
    }
}
