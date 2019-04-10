package scopes;

import beans.Aadhar;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import java.util.Map;

public class ThreadScope implements Scope {

    static {
        System.out.println("ThreadScope class loading...");
    }

    CustomThreadLocal threadLocal = new CustomThreadLocal();
    Map<String, Aadhar> scope = null;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        scope = (Map<String, Aadhar>) threadLocal.get();
        System.out.println("ThreadScope::get() method called..");
        System.out.println("Available Thread Scope : " + scope);

        //get aadhar object from the threadlocal object.
        Aadhar aadhar = scope.get(name);

        //if requested bean is not available in the ThreadLocal, then create a new bean object and add to ThreadLocal
        if(aadhar == null){
            aadhar = (Aadhar) objectFactory.getObject();
            System.out.println("Adding object to ThreadScope..");
            scope.put(name, aadhar);
            System.out.println("After adding, Thread Scope : " + scope);
        }

        //return aadhar object to the user
        return aadhar;
    }

    @Override
    public Object remove(String name) {
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        System.out.println("ThreadScope::remove() method called...");
        System.out.println("Available Thread Scope : " + scope);
        //remove bean from ThreadLocal
        scope = (Map<String, Aadhar>) threadLocal.get();
        Object obj = scope.remove(name);
        System.out.println("After removing, Thread Scope : " + scope);
        return obj;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
