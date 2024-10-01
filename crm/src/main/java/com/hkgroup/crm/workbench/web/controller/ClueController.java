package com.hkgroup.crm.workbench.web.controller;

import com.hkgroup.crm.commons.contants.Contants;
import com.hkgroup.crm.commons.domain.ReturnObject;
import com.hkgroup.crm.commons.utils.DateUtils;
import com.hkgroup.crm.commons.utils.UUIDUtils;
import com.hkgroup.crm.settings.domain.DicValue;
import com.hkgroup.crm.settings.domain.User;
import com.hkgroup.crm.settings.service.DicValueService;
import com.hkgroup.crm.settings.service.UserService;
import com.hkgroup.crm.workbench.domain.Activity;
import com.hkgroup.crm.workbench.domain.Clue;
import com.hkgroup.crm.workbench.domain.ClueRemark;
import com.hkgroup.crm.workbench.service.ActivityService;
import com.hkgroup.crm.workbench.service.ClueRemarkService;
import com.hkgroup.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ClueController {
    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ClueService clueService;

    @Autowired
    private ClueRemarkService clueRemarkService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/clue/index.do")
    public String index(HttpServletRequest request) {
        List<User> userLIst = userService.queryAllUsers();
        List<DicValue> appellationList = dicValueService.queryDiCValueByTypeCode("appellation");
        List<DicValue> clueStateList = dicValueService.queryDiCValueByTypeCode("clueState");
        List<DicValue> sourceList = dicValueService.queryDiCValueByTypeCode("source");
        request.setAttribute("userList", userLIst);
        request.setAttribute("appellationList", appellationList);
        request.setAttribute("clueStateList", clueStateList);
        request.setAttribute("sourceList", sourceList);
        return "/workbench/clue/index";
    }

    @RequestMapping("/workbench/clue/saveCreateClue.do")
    @ResponseBody
    public Object saveCreateClue(Clue clue, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateTime(DateUtils.formatDateTime(new Date()));
        clue.setCreateBy(user.getId());
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = clueService.saveCreateClue(clue);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统正忙，请稍后再试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统正忙，请稍后再试！");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String id,HttpServletRequest request) {
        Clue clue = clueService.queryClueForDetailById(id);
        List<ClueRemark> remarkList = clueRemarkService.queryClueRemarkForDetailBuClueId(id);
        List<Activity> activityList = activityService.queryActivityForDetailByClueId(id);
        request.setAttribute("clue", clue);
        request.setAttribute("remarkList", remarkList);
        request.setAttribute("activityList", activityList);
        return "workbench/clue/detail";
    }
}
