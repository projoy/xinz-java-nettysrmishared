package srmi;

import java.io.Serializable;

public class ShareMethod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6549773813868670329L;
	
	private int methodIndex;	//方法的下标
	private Object header;		//请求头
	private Object[] args;		//方法参数
	
	public ShareMethod(){
		
	}
	public ShareMethod(int methodIndex, Object header, Object[] args){
		this.methodIndex = methodIndex;
		this.header = header;
		this.args = args;
	}
	public int getMethodIndex() {
		return methodIndex;
	}
	public void setMethodIndex(int methodIndex) {
		this.methodIndex = methodIndex;
	}
	public Object getHeader() {
		return header;
	}
	public void setHeader(Object header) {
		this.header = header;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
}
