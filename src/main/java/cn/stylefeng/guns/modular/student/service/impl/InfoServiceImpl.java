package cn.stylefeng.guns.modular.student.service.impl;

import cn.stylefeng.guns.modular.student.dao.InfoMapper;
import cn.stylefeng.guns.modular.student.model.Info;
import cn.stylefeng.guns.modular.util.StringUtil;
import cn.stylefeng.guns.modular.student.service.IInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author siwei
 * @since 2019-01-21
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    @Override
    public boolean insertStudent(Info info) {
        // TODO Auto-generated method stub   
        info.setStuId(StringUtil.generate16ShortUUID());
        info.setCreateDate(new Date());
        info.setModifyDate(new Date());
        info.setDeleteFlag(0);
        return this.insert(info);
    }

}
