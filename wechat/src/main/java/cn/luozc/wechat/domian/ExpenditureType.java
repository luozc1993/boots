package cn.luozc.wechat.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 17:03 2018/12/26/026
 */
@Entity
@Table(name = "ab_expenditure_type")
@Getter
@Setter
@ToString
public class ExpenditureType {

    /** ID NUMBER 编号 PK主键自增长*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    /**name VARCHAR2(100) 类型名称*/
    @Column(name = "name",length = 100)
    private String name;

    /**remark VARCHAR2(500) 类型备注*/
    @Column(name = "remark",length = 500)
    private String remark;
}
