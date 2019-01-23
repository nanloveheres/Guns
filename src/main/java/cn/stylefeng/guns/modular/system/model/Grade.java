package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 年级班级信息表
 * </p>
 *
 * @author siwei
 * @since 2019-01-22
 */
@TableName("sys_grade")
public class Grade extends Model<Grade> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("grade_id")
    private String gradeId;
    /**
     * 班级类型名称
     */
    @TableField("grade_classroomName")
    private String gradeClassroomname;
    /**
     * 排序
     */
    @TableField("grade_num")
    private Integer gradeNum;
    /**
     * 季度类型名称
     */
    @TableField("grade_seasonClass")
    private String gradeSeasonclass;
    /**
     * 年级
     */
    @TableField("grade_level")
    private String gradeLevel;
    /**
     * 删除标识
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeClassroomname() {
        return gradeClassroomname;
    }

    public void setGradeClassroomname(String gradeClassroomname) {
        this.gradeClassroomname = gradeClassroomname;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    public String getGradeSeasonclass() {
        return gradeSeasonclass;
    }

    public void setGradeSeasonclass(String gradeSeasonclass) {
        this.gradeSeasonclass = gradeSeasonclass;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.gradeId;
    }

    @Override
    public String toString() {
        return "Grade{" +
        ", gradeId=" + gradeId +
        ", gradeClassroomname=" + gradeClassroomname +
        ", gradeNum=" + gradeNum +
        ", gradeSeasonclass=" + gradeSeasonclass +
        ", gradeLevel=" + gradeLevel +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
