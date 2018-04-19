package com.yonigo.miyage;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

public final class MiyageServerConfig {

    private static final String CONFIG_FILE_NAME = "miyage-server-configuration.yaml";
    private static final String DEFAULT_CONFIG_FILE_NAME = "/default-miyage-server-configuration.yaml";

    static private MiyageServerConfig instance = null;


    private MiyageServerConfig() {}


    private int port;


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static MiyageServerConfig getConfig() {
        if (instance == null) {
            Yaml yaml = new Yaml();
            try (InputStream in = ClassLoader.class.getResourceAsStream(DEFAULT_CONFIG_FILE_NAME)) {
                instance = yaml.loadAs(in, MiyageServerConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
