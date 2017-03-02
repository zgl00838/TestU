import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joshua
 * @name：绿信通发送信息DEMO
 * @version：1.0
 * @date：2016-03-21
 * @description：
 * 以下代码只是为了方便客户测试而提供的样例代码，客户可以根据自己网站的需要，按照技术文档自行编写,并非一定要使用该代码。
 * 该代码仅供学习和研究绿信通接口使用，只是提供一个参考。
 * @required: J2SE 1.7 httplient-4.3.5
 */
public class HttpSenderTest {
	
	private static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	
	public static void main(String[] args) {
		String url = "http://47.90.9.181:82/wgws/OrderServlet";// 应用地址
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("apName", "lcxx");
		map.put("apPassword", "lcxx88");
		map.put("calledNumber", "13326166788");
		map.put("content", "【绿城信息】你的验证码为44444，有效期2分钟。请填写验证码完成注册。");//用自己的内容白名单做测试
		//map.put("needstatus", String.valueOf(true));
		//map.put("sender", null);
		//map.put("type", "json");
		
		try {
			String returnString = HttpSender.send(url, map);
			System.out.println(returnString);
			// TODO 处理返回值,参见绿信通协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}
