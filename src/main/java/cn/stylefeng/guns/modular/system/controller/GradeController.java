package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Grade;
import cn.stylefeng.guns.modular.system.service.IGradeService;

/**
 * 年级班务管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-22 14:27:36
 */
@Controller
@RequestMapping("/grade")
public class GradeController extends BaseController {

    private String PREFIX = "/system/grade/";

    @Autowired
    private IGradeService gradeService;

    /**
     * 跳转到年级班务管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "grade.html";
    }

    /**
     * 跳转到添加年级班务管理
     */
    @RequestMapping("/grade_add")
    public String gradeAdd() {
        return PREFIX + "grade_add.html";
    }

    /**
     * 跳转到修改年级班务管理
     */
    @RequestMapping("/grade_update/{gradeId}")
    public String gradeUpdate(@PathVariable String gradeId, Model model) {
        Grade grade = gradeService.selectById(gradeId);
        model.addAttribute("item",grade);
        LogObjectHolder.me().set(grade);
        return PREFIX + "grade_edit.html";
    }

    /**
     * 获取年级班务管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return gradeService.selectList(null);
    }

    /**
     * 新增年级班务管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Grade grade) {
        if(!gradeService.insertGrade(grade)) {
            return ResponseData.error("信息已存在");
        }
        return SUCCESS_TIP;
    }

    /**
     * 删除年级班务管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String gradeId) {
        gradeService.deleteById(gradeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改年级班务管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Grade grade) {
        gradeService.updateById(grade);
        return SUCCESS_TIP;
    }
    
    /**
     * 列出班级类型
     */
    @RequestMapping(value = "/listClassType")
    @ResponseBody
    public List<String> listClassType() {
        return gradeService.listClassType();
    }
    
    /**
     * 列出年级类型
     */
    @RequestMapping(value = "/listGradeType")
    @ResponseBody
    public List<String> listGradeType() {
        return gradeService.listGradeType();
    }

    /**
     * 年级班务管理详情
     */
    @RequestMapping(value = "/detail/{gradeId}")
    @ResponseBody
    public Object detail(@PathVariable("gradeId") String gradeId) {
        return gradeService.selectById(gradeId);
    }
}
