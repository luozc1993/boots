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

    /** 角色与用户存在N-N关联 */
    /**  用户和部门存在多对一的关联 部门 FK(OA_ID_DEPT)   */
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ExpenditureType.class)
    @JoinColumn(name = "type",referencedColumnName = "ID",foreignKey = @ForeignKey(name = "FK_Expenditure_ExpenditureType"))
    private ExpenditureType type;

    /**time 支出类型*/
    @Column(name = "time")
    private Long time;
}
