package bls.util;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LibraryLoader {

    public void loadNativeLibrary(String libName) {
        String osName = Optional.ofNullable(System.getProperty("os.name")).map(String::toLowerCase).orElse(null);
        OperatingSystem os = OperatingSystem.getOperatingSystem(osName);

        loadNativeLibrary(libName, os);
    }

    public void loadNativeLibrary(String libName, OperatingSystem os){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String filename = getLibPath(os, libName);
        String libPath = Optional.ofNullable(classLoader.getResource(filename))
            .map(URL::getPath)
            .orElseThrow(() -> new IllegalStateException("Could not load native lib as file [" + filename + "] not found"));

        System.load(libPath);
    }

    private String getLibPath(OperatingSystem os, String libName) {
        return "lib/" + os.getLibFilename(libName);
    }

    public enum OperatingSystem {
        LINUX("linux/lib%s.so", "nix", "nux"),
        WINDOWS("windows/lib%s.dll", "win"),
        MAC_OS("mac/lib%s.dylib","mac");

        private final String fileFormat;
        private final List<String> osMatcher;

        OperatingSystem(String fileFormat, String ... osMatcher){
            this.fileFormat = fileFormat;
            this.osMatcher = Arrays.asList(osMatcher);
        }

        public static OperatingSystem getOperatingSystem(String name) {
            for (OperatingSystem operatingSystem : values()){
                if(operatingSystem.osMatcher.stream().anyMatch(name::contains)){
                    return operatingSystem;
                }
            }

            throw new IllegalStateException("Could not derive OS");
        }

        public String getLibFilename(String libName){
            return String.format(fileFormat, libName);
        }
    }
}
