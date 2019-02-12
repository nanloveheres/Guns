package cn.stylefeng.guns.modular.student.dao;

import cn.stylefeng.guns.modular.student.model.Info;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author siwei
 * @since 2019-01-21
 */
public interface InfoMapper extends BaseMapper<Info> {

    List<Info> listUserStudent(Integer id);
    
    Integer deleteStudent(String id);

}
