package ro.coreblock.implementation.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import ro.coreblock.LoadingCore;
import ro.coreblock.api.config.auth.LanguageType;
import ro.coreblock.api.config.auth.ObjectConfiguration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public abstract class AbstractConfiguration {

    @SneakyThrows
    public List<ObjectConfiguration> createConfiguration(LoadingCore loadingCore, String configurationTypePath) {
        var pluginResourceDirectoryPath = Paths.get(loadingCore.getDataFolder().getAbsolutePath());
        var configurationTypeDirectoryPath = Paths.get(pluginResourceDirectoryPath + "/" + configurationTypePath).toFile();

        if (!pluginResourceDirectoryPath.toFile().exists()) {
            pluginResourceDirectoryPath.toFile().mkdirs();
        }

        if (!configurationTypeDirectoryPath.isDirectory()) {
            configurationTypeDirectoryPath.mkdirs();
        }

        final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        try (final JarFile jar = new JarFile(jarFile)) {
            final Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                final JarEntry jarEntry = entries.nextElement();
                final String name = jarEntry.getName();
                if (name.startsWith(configurationTypePath + "/")) {
                    if (name.equals(configurationTypePath + "/")) continue;
                    InputStream input = jar.getInputStream(jarEntry);
                    String jsonContent = processJsonFromJar(input);
                    var resourcePath = pluginResourceDirectoryPath + "/" + name;
                    if (!Paths.get(resourcePath).toFile().exists()) {
                        var jsonNode = JsonMapper.builder().build().readTree(jsonContent);
                        Files.createFile(Paths.get(resourcePath));
                        JsonMapper.builder().build().writeValue(new File(resourcePath), jsonNode);
                    }
                }
            }
        }

        return loadConfiguration(loadingCore, configurationTypePath);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JsonFactory jsonFactory = new JsonFactory();

    @SneakyThrows
    public List<ObjectConfiguration> loadConfiguration(LoadingCore loadingCore, String path) {
        List<ObjectConfiguration> objectConfigurations = new ArrayList<>();
        try (var paths = Files.walk(Paths.get(loadingCore.getDataFolder().getAbsolutePath() + "/" + path))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(resourcePath -> {
                        if (!resourcePath.toString().contains(".json")) return;
                        final var languageType = resourcePath.toFile().getName().replace(".json", "").toUpperCase();
                        ObjectConfiguration objectConfiguration = new ObjectConfiguration();
                        objectConfiguration.setLanguageType(LanguageType.valueOf(languageType));
                        try {
                            JsonParser jsonParser = jsonFactory.createParser(resourcePath.toFile());
                            var temporaryMap = objectMapper.readValues(jsonParser, new TypeReference<Map<String, String>>() {});
                            Map<String, String> languageSet = new HashMap<>();
                            temporaryMap.readAll().forEach(languageSet::putAll);

                            objectConfiguration.setLanguageSet(languageSet);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        objectConfigurations.add(objectConfiguration);
                    });
        }

        return processConfigurationReplacements(objectConfigurations);
    }

    protected List<ObjectConfiguration> processConfigurationReplacements(List<ObjectConfiguration> objectConfigurations) {
        return objectConfigurations.stream()
                .peek(option -> {
                    AtomicReference<Map<String, String>> temporaryMap = new AtomicReference<>();
                    option.getLanguageSet().forEach((k, v) -> {
                        option.getLanguageSet().replace(k, v, v.replace("{red}", ChatColor.RED.toString()));
                        option.getLanguageSet().replace(k, v, v.replace("{yellow}", ChatColor.YELLOW.toString()));
                        option.getLanguageSet().replace(k, v, v.replace("{gray}", ChatColor.GRAY.toString()));
                        temporaryMap.set(option.getLanguageSet());
                    });
                    option.setLanguageSet(temporaryMap.get());
                })
                .toList();
    }

    private static String processJsonFromJar(InputStream input) throws IOException {
        var inputStreamReader = new InputStreamReader(input);
        var bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        bufferedReader.close();

        return stringBuilder.toString();
    }
}
