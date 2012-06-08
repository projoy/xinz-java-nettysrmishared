package srmi;

import global.ShareContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class NativeInvoker {

	ShareContext context;
	/**
	 * 实现接口的类
	 */
	Object[] implementers;
	public NativeInvoker(){
		
	}
	public NativeInvoker(ShareContext context){
		this.context = context;
		implementers = new Object[context.getInterfaceSize()];
	}
	
	/**
	 * 映射接口（初始化时调用）服务端将接口与实现接口的类进行映射，用于方法调用。
	 * @param clazz
	 * @param implementer
	 */
	public <T>void mapInterface(Class<T> clazz,T implementer){
		int index = context.getInterfaceIndex(clazz);
		if(implementers[index] != null){
			System.err.println("接口被重复实现："+clazz);
		}
		implementers[index] = implementer;
	}
	
	public void invoke(ShareMethod nativeMethod){
		//获取方法
		Method method = context.getMethod(nativeMethod.getMethodIndex());
		//获取接口下标
		Integer interfaceIndex = context.getInterfaceIndex(method.getDeclaringClass());
		//获取接口对应的实现
		Object obj = implementers[interfaceIndex];
		//获取方法的参数
		Object[] args = nativeMethod.getArgs();
		try {
			//调用服务端本地方法
			method.invoke(obj, args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
