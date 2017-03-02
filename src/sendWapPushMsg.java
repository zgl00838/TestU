import common.msg.util.MsgContainer;

public class sendWapPushMsg {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MsgContainer test=new MsgContainer();
		test.sendWapPushMsg("http", "d", "你好");
	}
}
