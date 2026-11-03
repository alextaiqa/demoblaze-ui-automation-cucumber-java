package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    //switch used in TCs test context. It should be scenario context as test context is for framework-level objects
    //like drivers, utils. It is a manual dependency container. Also, I have Pico, so TestContext can be deleted if not needed in hooks

    private Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key){
        return data.get(key);
    }

    public <T> T get(String key, Class<T> type){
        return type.cast(data.get(key));
    }

    public void clear(){
        data.clear();
    }
}
