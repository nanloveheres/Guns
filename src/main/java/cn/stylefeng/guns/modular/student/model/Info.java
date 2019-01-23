package cn.stylefeng.guns.modular.student.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author siwei
 * @since 2019-01-21
 */
@TableName("stu_info")
public class Info extends Model<Info> {

    private static final long serialVersionUID = 1L;

    @TableId("stu_Id")
    private String stuId;
    /**
     * 学生姓名
     */
    @TableField("stu_name")
    private String stuName;
    /**
     * 学生班级
     */
    @TableField("stu_class")
    private String stuClass;
    /**
     * 所在年级
     */
    @TableField("stu_grade")
    private String stuGrade;
    /**
     * 性别
     */
    @TableField("stu_sex")
    private Integer stuSex;
    /**
     * 学校
     */
    @TableField("stu_school")
    private String stuSchool;
    /**
     * 家长电话
     */
    @TableField("stu_parentPhone")
    private String stuParentphone;
    /**
     * 入学时间
     */
    @TableField("stu_admissionTime")
    private String stuAdmissiontime;
    @TableField("createDate")
    private Date createDate;
    @TableField("modifyDate")
    private Date modifyDate;
    @TableField("deleteFlag")
    private Integer deleteFlag;


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public Integer getStuSex() {
        return stuSex;
    }

    public void setStuSex(Integer stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuParentphone() {
        return stuParentphone;
    }

    public void setStuParentphone(String stuParentphone) {
        this.stuParentphone = stuParentphone;
    }

    public String getStuAdmissiontime() {
        return stuAdmissiontime;
    }

    public void setStuAdmissiontime(String stuAdmissiontime) {
        this.stuAdmissiontime = stuAdmissiontime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.stuId;
    }

    @Override
    public String toString() {
        return "Info{" +
        ", stuId=" + stuId +
        ", stuName=" + stuName +
        ", stuClass=" + stuClass +
        ", stuGrade=" + stuGrade +
        ", stuSex=" + stuSex +
        ", stuSchool=" + stuSchool +
        ", stuParentphone=" + stuParentphone +
        ", stuAdmissiontime=" + stuAdmissiontime +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
