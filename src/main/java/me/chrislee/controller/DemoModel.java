package me.chrislee.controller;

import java.util.Map;

/**
 * Created by ChrisLee on 15-4-25.
 * Model示例
 */
public class DemoModel {
    private boolean flag = true;
    private String msg = "";
    private Map<String, Object> data = null;

    public DemoModel(boolean flag, String msg, Map<String, Object> data){
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public void add(String key, Object value){
        data.put(key, value);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
