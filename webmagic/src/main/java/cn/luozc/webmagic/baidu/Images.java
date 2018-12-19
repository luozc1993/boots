package cn.luozc.webmagic.baidu;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class Images implements PageProcessor {


    // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
    private Site site = Site.me().setCharset("utf8").setRetryTimes(1000).setSleepTime(1000);
    //爬取的页数
    public static int PAGE_SIZE = 1;
    //下载张数
    public static int INDEX_PHOTO =0;
    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        List<String> all = html.xpath("//div[@class='cell']/a/@href").all();
        page.addTargetRequests(all);
        System.out.println(all.size());
    }


    public static void main(String[] args) {

        Html html = new Html("<div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219179\\\" target=\\\"_blank\\\" title=\\\"950 x 684 - (82.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/162\\/w1024h738\\/20181204\\/U_Mt-hphsupy0069516.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219180\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (62.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/NRiu-hpinryc2372405.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219181\\\" target=\\\"_blank\\\" title=\\\"704 x 1024 - (83.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/128\\/w704h1024\\/20181204\\/zeAl-hpinryc2372407.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219183\\\" target=\\\"_blank\\\" title=\\\"675 x 1024 - (68.2K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/99\\/w675h1024\\/20181204\\/bZWs-hphsupy0069392.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219182\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (108.7K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/sJjq-hprknvs9358374.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219184\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (77.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/BnQd-hpfycet2227510.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219185\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (49.3K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/-qoG-hpinryc2372413.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219186\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (101.3K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/F9Rv-hprknvs9358379.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219187\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (178.5K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/ir2u-hphsupy0069444.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219188\\\" target=\\\"_blank\\\" title=\\\"676 x 1024 - (70.9K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/100\\/w676h1024\\/20181204\\/WGkd-hprknvs9358393.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219189\\\" target=\\\"_blank\\\" title=\\\"505 x 1024 - (70.7K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/729\\/w505h1024\\/20181204\\/5IQX-hpinryc2372477.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219191\\\" target=\\\"_blank\\\" title=\\\"547 x 1024 - (61.1K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/771\\/w547h1024\\/20181204\\/pjvb-hpfycet2227613.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/o\\/slide_2_730_200578.html?img=3219190\\\" target=\\\"_blank\\\" title=\\\"564 x 1024 - (87.6K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/sipaphoto\\/49d350e9\\/788\\/w564h1024\\/20181204\\/XD07-hpfycet2227600.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u76d8\\u70b9\\u8fd0\\u52a8\\u5c0f<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u9732\\u897f\\u00b7\\u6d77\\u5c14<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-12-04 09:57<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843024\\\" target=\\\"_blank\\\" title=\\\"948 x 718 - (383.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/66\\/w948h718\\/20181130\\/TCaG-hpinrya9055211.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843023\\\" target=\\\"_blank\\\" title=\\\"948 x 692 - (392.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/40\\/w948h692\\/20181130\\/ERNQ-hpevhcm5362391.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843025\\\" target=\\\"_blank\\\" title=\\\"948 x 600 - (278.0K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/748\\/w948h600\\/20181130\\/EBUX-hpinrya9055213.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843026\\\" target=\\\"_blank\\\" title=\\\"948 x 632 - (308.1K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/780\\/w948h632\\/20181130\\/JbDQ-hpfyces8983226.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843027\\\" target=\\\"_blank\\\" title=\\\"948 x 632 - (384.5K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/780\\/w948h632\\/20181130\\/-cTR-hpinrya9055221.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sd.sina.com.cn\\/news\\/slide_56_52240_550637.html?img=843028\\\" target=\\\"_blank\\\" title=\\\"948 x 649 - (350.3K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sd\\/56_img\\/upload\\/7ceea6c5\\/797\\/w948h649\\/20181130\\/gdlx-hpinrya9055222.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:59<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div><div class=\\\"cell\\\" onmouseover=\\\"this.className='cell hover'\\\" onmouseout=\\\"this.className='cell';\\\"><a href=\\\"http:\\/\\/slide.sports.sina.com.cn\\/n\\/slide_2_19451_200271.html?img=3214224\\\" target=\\\"_blank\\\" title=\\\"948 x 649 - (343.2K)\\\"><img src=\\\"http:\\/\\/n.sinaimg.cn\\/sports\\/2_img\\/upload\\/85dcfa84\\/797\\/w948h649\\/20181130\\/w46X-hpfyces8947771.jpg\\\"><p style=\\\"padding-top:5px;padding-bottom:0px;line-height:18px;color:#333;\\\">\\u9c81\\u80fd<span style=\\\"color:#C03\\\">\\u7f8e\\u5973<\\/span>\\u7403\\u8ff7\\u60ca\\u8273\\u8db3\\u534f\\u676f\\u51b3\\u8d5b<\\/p><p style=\\\"color:#999;padding-top:3px;padding-bottom:3px;\\\" class=\\\"fgray_time\\\">2018-11-30 19:03<\\/p><\\/a><span class=\\\"pic_hd\\\" title=\\\"\\u9ad8\\u6e05\\\" onmouseover=\\\"this.className='pic_hd hover'\\\" onmouseout=\\\"this.className='pic_hd'\\\">\\u9ad8\\u6e05<\\/span><\\/div>");
        List<String> all = html.xpath("div[@class='cell']/a/@href").all();
        System.out.println(all.size());


    }

}