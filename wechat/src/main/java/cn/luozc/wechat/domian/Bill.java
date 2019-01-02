package cn.luozc.wechat.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 16:56 2018/12/26/026
 */
@Entity
@Table(name = "ab_bill")
@Getter
@Setter
@ToString
public class Bill {

    /** ID NUMBER 编号 PK主键自增长*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    /**money 金额*/
    @Column(name = "money")
    private double money;

    /**type 收入或支出*/
    @Column(name = "type")
    private int type;

    /**time 时间*/
    @Column(name = "time")
    private Long time;

    /**
     * 用户微信id
     */
    @Column(name = "openid")
    private String  openid;

    /**
     * 账单类型
     */
    @Column(name = "type_name")
    private String typeName;
}
