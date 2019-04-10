package scopes;

import beans.Aadhar;

import java.util.HashMap;
import java.util.Map;

public class CustomThreadLocal extends ThreadLocal<Map<String, Aadhar>>{
    static {
        System.out.println("CustomThreadLocal class loading...");
    }
    @Override
    protected Map<String, Aadhar> initialValue() {
        System.out.println("CustomThreadLocal::initialValue() method called..");
        return new HashMap<String, Aadhar>();
    }
}
