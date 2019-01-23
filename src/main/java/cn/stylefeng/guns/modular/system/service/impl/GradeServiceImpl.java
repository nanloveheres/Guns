package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Grade;
import cn.stylefeng.guns.modular.system.dao.GradeMapper;
import cn.stylefeng.guns.modular.system.service.IGradeService;
import cn.stylefeng.guns.modular.util.StringUtil;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 年级班级信息表 服务实现类
 * </p>
 *
 * @author siwei
 * @since 2019-01-22
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {

    @Autowired
    private GradeMapper gradeMapper;
    
    @Override
    public boolean insertGrade(Grade grade) {
        boolean result;
        grade.setGradeId(StringUtil.generate16ShortUUID());
        grade.setDeleteFlag(0);
        if(gradeMapper.insertCheck(grade)==0) {
            result = this.insert(grade);
        }else {
            result = false;
        }
        return result;
    }

}
