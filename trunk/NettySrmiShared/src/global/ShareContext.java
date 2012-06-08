package global;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import srmi.IndexMap;

public class ShareContext {

	/**
	 * 方法集合
	 */
	IndexMap<Method> methodMap = new IndexMap<Method>();
	/**
	 * 接口集合
	 */
	IndexMap<Class<?>> interfaceMap = new IndexMap<Class<?>>();
	
	public ShareContext(){
		
	}
	public void init(){
		//将接口的方法放到IndexMap中
		for(Class<?> clazz: interfaceMap.getList()){
			for(Method method: clazz.getMethods()){
				methodMap.put(method);
			}
		}
	}
	
	public void addInterface(Class<?> clazz){
		interfaceMap.put(clazz);
	}
	
	public int getInterfaceSize(){
		return interfaceMap.size();
	}
	
	public int getInterfaceIndex(Class<?> obj){
		return interfaceMap.indexOf(obj);
	}
	
	public Class<?> getInterface(int index){
		return interfaceMap.get(index);
	}
	
	public int getMethodIndex(Method method){
		return methodMap.indexOf(method);
	}
	
	public Method getMethod(int index){
		return methodMap.get(index);
	}
}
