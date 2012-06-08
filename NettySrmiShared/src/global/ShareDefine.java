package global;

import shared.DefaultInterface;

public class ShareDefine {

	public static final ShareContext context = new ShareContext();
	static{
		context.addInterface(DefaultInterface.class);
		
		context.init();
	}
}
