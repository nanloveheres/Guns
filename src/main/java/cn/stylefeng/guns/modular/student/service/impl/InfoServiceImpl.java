package cn.stylefeng.guns.modular.student.service.impl;

import cn.stylefeng.guns.config.web.ShiroConfig;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.modular.student.dao.InfoMapper;
import cn.stylefeng.guns.modular.student.model.Info;
import cn.stylefeng.guns.modular.util.StringUtil;
import cn.stylefeng.guns.modular.student.service.IInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private InfoMapper infoMapper;
    
    @Override
    public boolean insertStudent(Info info) {
        // TODO Auto-generated method stub   
        info.setStuId(StringUtil.generate16ShortUUID());
        info.setCreateDate(new Date());
        info.setModifyDate(new Date());
        info.setDeleteFlag(0);
        //当前登录人
        ShiroUser user = ShiroKit.getUser();
        info.setTeacherId(user.getId()+"");    
        return this.insert(info);
    }

    @Override
    public Object listUserStudent(ShiroUser user) {
        // TODO Auto-generated method stub
        return infoMapper.listUserStudent(user.getId());
    }

    @Override
    public boolean deleteStudentById(String stuId) {
        // TODO Auto-generated method stub
        Integer deleteType = infoMapper.deleteStudent(stuId);
        if(null!=deleteType && 0!=deleteType ) {
            return true;
        }else {
            return false;
        }
    }

}
