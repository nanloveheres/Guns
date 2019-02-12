package cn.stylefeng.guns.modular.student.service;

import com.baomidou.mybatisplus.service.IService;

import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.modular.student.model.Info;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author siwei
 * @since 2019-01-21
 */
public interface IInfoService extends IService<Info> {

    boolean insertStudent(Info info);

    Object listUserStudent(ShiroUser user);
    
    boolean deleteStudentById(String stuId);
}
