package falcon.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	
	private static final String IP_REX = "\\.{3}?";
	
	
	public static void main(String[] args) throws IOException {
		
		Document  doc = Jsoup.connect("http://ip84.com/")
		.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36").get();
		Elements ips = doc.getElementsByClass("list");
		List<Element>  hightAnyTrs = new ArrayList<Element>();
		List<Map<String,String>> ipList = new ArrayList<Map<String,String>>();
		for(Element ipTable :ips){
		
			
			//Element tr = ipTable.getElementsByTag(tagName);
			
			Elements tds = ipTable.getElementsByTag("td");
			for(Element td :tds){
				String text = td.text();
				if("高匿".equals(text)){
					hightAnyTrs.add(td.parent());
					break;
				}
			}
		}
		for(Element tr :hightAnyTrs){
			Elements tds = tr.children();
			Map<String,String> ipDetail = new HashMap<String,String>();
			int size = tds.size();
			for(int i = 0;i<size;i++){
				switch(i){
				case 0:
					ipDetail.put("ip", tds.get(i).html());
				break;
				case 1:
					ipDetail.put("port", tds.get(i).html());
				break;
				case 2:
					ipDetail.put("area", tds.get(i).html());
				break;
				case 3:
					ipDetail.put("any", tds.get(i).html());
				break;
				case 4:
					ipDetail.put("protocol", tds.get(i).html());
				break;
				case 5:
					ipDetail.put("speed", tds.get(i).html());
				break;
				case 6:
					ipDetail.put("checkTimeDes", tds.get(i).html());
				break;
				default:
					break;
				
				}
			}
			ipList.add(ipDetail);
		}
		
		
		System.out.println(ipList.toString());
	}
	
    private static boolean match(String regex,String str){
    	Pattern pt = Pattern.compile(regex);
    	Matcher mr = pt.matcher(str);
    	return mr.matches();
    }
	
}
