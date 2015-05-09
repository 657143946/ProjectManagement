package me.chrislee.utils.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created by ChrisLee on 14-8-30.
 * 实体与json字符串之间的转化
 */
public class JsonConvert {
    public static HashMap<String, String> jsonToMap(String json) {
        HashMap<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static HashMap<String, Object> jsonToMapExtend(String json) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, Object>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }


    public static String entityToJson(Object entity) {
        StringWriter str=new StringWriter();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            objectMapper.writeValue(str, entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str.toString();
    }


    public static <T> T jsonToEntity(String json, T t) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            t = (T)objectMapper.readValue(json, t.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


}
