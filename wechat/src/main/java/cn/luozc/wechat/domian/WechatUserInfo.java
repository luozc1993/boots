package cn.luozc.wechat.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 14:36 2018/12/26/026
 */
@Entity
@Table(name = "wx_user")
@Getter
@Setter
@ToString
public class WechatUserInfo {

    /** ID NUMBER 编号 PK主键自增长*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**openid VARCHAR2(100) 微信id*/
    @Column(name = "openid",length = 100)
    private String openid;

    /**nick_name VARCHAR2(100) 微信昵称*/
    @Column(name = "nick_name",length = 100)
    private String nickName;

    /**avatar_url VARCHAR2(200) 用户头像链接*/
    @Column(name = "avatar_url",length = 200)
    private String avatarUrl;

    /**gender  用户性别 0未知  1 男  2女*/
    @Column(name = "gender",length = 200)
    private short gender;

    /**country VARCHAR2(100) 用户所在国家*/
    @Column(name = "country",length =100)
    private String country;

    /**province VARCHAR2(100) 用户所在省份*/
    @Column(name = "province",length =100)
    private String province;

    /**city VARCHAR2(100) 用户所在城市*/
    @Column(name = "city",length =100)
    private String city;

    /**language VARCHAR2(50) 显示 country，province，city 所用的语言*/
    @Column(name = "language",length =50)
    private String language;

}
