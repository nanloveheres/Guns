package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Grade;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 年级班级信息表 服务类
 * </p>
 *
 * @author siwei
 * @since 2019-01-22
 */
public interface IGradeService extends IService<Grade> {

    boolean insertGrade(Grade grade);

}
