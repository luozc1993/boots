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
@Table(name = "ab_expenditure")
@Getter
@Setter
@ToString
public class Expenditure {

    /** ID NUMBER 编号 PK主键自增长*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "money")
    private double money;

    @Column(name = "ceneration_type")
    private int cenerationType;

    /**time 支出类型*/
    @Column(name = "time")
    private Long time;

    @Column(name = "openid")
    private String  openid;

    @Column(name = "type")
    private int type;
}
