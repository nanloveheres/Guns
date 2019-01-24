package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Grade;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 年级班级信息表 Mapper 接口
 * </p>
 *
 * @author siwei
 * @since 2019-01-22
 */
public interface GradeMapper extends BaseMapper<Grade> {
    Integer insertCheck(Grade grade);

    List<String> listClassType();

    List<String> listGradeType();
}
