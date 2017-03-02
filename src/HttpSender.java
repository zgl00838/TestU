import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

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
public class HttpSender {

	/**
	 * 
	 * @param url
	 *            应用地址，类似于http://ip:port/sms/send
	 * @param map
	 *            参数列表
	 * @return 返回值定义参见协议文档
	 * @throws Exception
	 */
	public static String send(String url, Map<String, String> map) {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httppost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String name = it.next();
			params.add(new BasicNameValuePair(name, map.get(name)));
		}

		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();

			return EntityUtils.toString(entity, StandardCharsets.UTF_8);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
