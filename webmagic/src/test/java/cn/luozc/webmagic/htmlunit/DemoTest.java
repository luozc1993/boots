package cn.luozc.webmagic.htmlunit;

import cn.luozc.utils.SVGUtil;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.junit.Test;

import java.io.*;

public class DemoTest {
    @Test
    public void homePage_Firefox() throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52)) {
            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
            System.out.println(page.getTitleText());
        }
    }

    @Test
    public void homePage() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
            System.out.println( page.getTitleText());

            final String pageAsXml = page.asXml();
            System.out.println(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
            System.out.println(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        }
    }
    @Test
    public void documentWrite() throws Exception {
        final WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true); // 启动JS
        webClient.getOptions().setUseInsecureSSL(true);//忽略ssl认证
        webClient.getOptions().setCssEnabled(false);//禁用Css，可避免自动二次请求CSS进行渲染
        webClient.getOptions().setThrowExceptionOnScriptError(false);//运行错误时，不抛出异常
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());// 设置Ajax异步
        final HtmlPage page = webClient.getPage("http://127.0.0.1:8080/baogao/page/chart/chart.html");
        //执行js
        String hrefValue = "javascript:getSvg();";
        ScriptResult s = page.executeJavaScript(hrefValue);//执行js方法
        String svg = s.getJavaScriptResult().toString();
        SVGUtil.convertToPng(svg,"D:/q.png");
    }



}
