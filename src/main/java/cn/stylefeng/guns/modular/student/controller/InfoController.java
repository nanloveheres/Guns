package cn.stylefeng.guns.modular.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.student.model.Info;
import cn.stylefeng.guns.modular.student.service.IInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;

/**
 * student_info控制器
 *
 * @author fengshuonan
 * @Date 2019-01-21 14:42:43
 */
@Controller
@RequestMapping("/info")
public class InfoController extends BaseController {

    private String PREFIX = "/student/info/";

    @Autowired
    private IInfoService infoService;

    /**
     * 跳转到student_info首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "info.html";
    }

    /**
     * 跳转到添加student_info
     */
    @RequestMapping("/info_add")
    public String infoAdd() {
        return PREFIX + "info_add.html";
    }

    /**
     * 跳转到修改student_info
     */
    @RequestMapping("/info_update/{infoId}")
    public String infoUpdate(@PathVariable Integer infoId, Model model) {
        Info info = infoService.selectById(infoId);
        model.addAttribute("item",info);
        LogObjectHolder.me().set(info);
        return PREFIX + "info_edit.html";
    }

    /**
     * 获取student_info列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return infoService.selectList(null);
    }

    /**
     * 新增student_info
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Info info) {
        infoService.insertStudent(info);
        return SUCCESS_TIP;
    }

    /**
     * 删除student_info
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer infoId) {
        infoService.deleteById(infoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改student_info
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Info info) {
        infoService.updateById(info);
        return SUCCESS_TIP;
    }

    /**
     * student_info详情
     */
    @RequestMapping(value = "/detail/{infoId}")
    @ResponseBody
    public Object detail(@PathVariable("infoId") Integer infoId) {
        return infoService.selectById(infoId);
    }
}
