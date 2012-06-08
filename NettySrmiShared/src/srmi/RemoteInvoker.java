package srmi;

import global.ShareContext;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteInvoker implements InvocationHandler{

	private ShareContext context;
	
	private String host;
	private int port;
	
	public RemoteInvoker(ShareContext context,String host, int port){
		this.context = context;
		this.host = host;
		this.port = port;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object header = null;	//暂时为空
		int methodIndex = context.getMethodIndex(method);
		ShareMethod shareMethod = new ShareMethod(methodIndex,header,args);
		//连接服务器
		HttpURLConnection conn = (HttpURLConnection) new URL("http://"+host+":"+port).openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.connect();
		ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
		oos.writeObject(shareMethod);
		oos.flush();
		oos.close();
		conn.getInputStream();
		conn.disconnect();
		return Integer.valueOf(0);
	}

}
