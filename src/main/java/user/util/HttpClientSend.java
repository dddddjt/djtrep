package user.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientSend {
	 public static String sendPost(String urlParam) throws HttpException, IOException {
	        // 创建httpClient实例对象
	        HttpClient httpClient = new HttpClient();
	        // 设置httpClient连接主机服务器超时时间：15000毫秒
	        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
	        // 创建post请求方法实例对象
	        PostMethod postMethod = new PostMethod(urlParam);
	        // 设置post请求超时时间
	        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
	        postMethod.addRequestHeader("Content-Type", "application/json");
	        
	        httpClient.executeMethod(postMethod);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while((str = reader.readLine())!=null){
                stringBuffer.append(str);
            }
	       // String result = postMethod.getResponseBodyAsString();
	        postMethod.releaseConnection();
	        return str;
	    }
	    public static String sendGet(String urlParam) throws HttpException, IOException {
	        // 创建httpClient实例对象
	        HttpClient httpClient = new HttpClient();
	        // 设置httpClient连接主机服务器超时时间：15000毫秒
	        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
	        // 创建GET请求方法实例对象
	        GetMethod getMethod = new GetMethod(urlParam);
	        // 设置post请求超时时间
	        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
	        getMethod.addRequestHeader("Content-Type", "application/json");

	        httpClient.executeMethod(getMethod);

	        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while((str = reader.readLine())!=null){
                stringBuffer.append(str);
            }
	       // String result = postMethod.getResponseBodyAsString();
	        getMethod.releaseConnection();
	        return str;
	    }
}
