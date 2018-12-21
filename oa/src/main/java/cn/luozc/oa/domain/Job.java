package cn.luozc.oa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 职位
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 11:48 2018/12/21/021
 */
@Entity
@Table(name="OA_ID_JOB")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Job implements Serializable {

    /**
     * CODE	VARCHAR2(100) 代码 PK主键
     */
    @Id
    @Column(name="CODE", length=100)
    private String code;


    /** NAME VARCHAR2(50) 名称 */
    @Column(name="NAME", length=50)
    private String name;


    /** REMARK	VARCHAR2(300) 职位说明*/
    @Column(name="REMARK", length=300)
    private String remark;

    /** setter and getter method */
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
