package com.service;

import com.entity.SystemUserEntity;
import com.entity.param.OperatorParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ZYL
 * @date 2018/11/28 10:26
 */
public interface SystemUserService {
    /**
     * 管理员登录
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-11-28
     */
    boolean login(SystemUserEntity param, HttpServletRequest request);

    /**
     * 模糊查询
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-11-30
     */
    Map<String, Object> selectByParam(OperatorParam param);

    /**
     * 查询有效的系统管理员
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-11-29
     */
    Map<String, Object> queryOperatorAll(OperatorParam param);

    /**
     * 更新管理员信息
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-12-03
     */
    int updateOperatorInfo(OperatorParam param);

    /**
     * 删除管理员信息
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-12-03
     */
    int deleteOperator(OperatorParam param);

    /**
     * 添加管理员
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-12-03
     */
    int addOperator(OperatorParam param);
}
