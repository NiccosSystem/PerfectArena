package net.niccossystem.perfectarena.perfectclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.niccossystem.perfectarena.PerfectArena;
import net.niccossystem.perfectarena.serialize.PerfectClassSerializer;


public class PerfectClassHandler {
    
    private final PerfectArena plugin;
    private final List<PerfectClass> perfectClasses;
    
    public PerfectClassHandler(PerfectArena instance) {
        plugin = instance;
        perfectClasses = scanClasses();
    }
    
    public List<PerfectClass> scanClasses() {
        List<PerfectClass> loadedClasses = new ArrayList<PerfectClass>();
        Map<String, List<String>> classesInConfig = convertValuesToArrayList(plugin.getConfig().getConfigurationSection("classes").getValues(false));
        
        for (String className : classesInConfig.keySet()) {
            loadedClasses.add(PerfectClassSerializer.deserialize(className, classesInConfig.get(className)));
        }
        return loadedClasses;
    }

    @SuppressWarnings("unchecked")
    private Map<String, List<String>> convertValuesToArrayList(Map<String, Object> config) {
        Map<String, List<String>> convertedMap = new HashMap<String, List<String>>();
        
        for (String key : config.keySet()) {
            convertedMap.put(key, (List<String>) config.get(key));   
        }
        return convertedMap;
    }

    public PerfectClass getClassByName(String stringClass) {
        PerfectClass objectClass = null;
        
        for (PerfectClass pClass : perfectClasses) {
            if (!pClass.getName().equalsIgnoreCase(stringClass)) {
                continue;
            }
            objectClass = pClass;
            break;
        }        
        return objectClass;
    }

    public List<PerfectClass> getPerfectClasses() {
        return perfectClasses;
    }
}
