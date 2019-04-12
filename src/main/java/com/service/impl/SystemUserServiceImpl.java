package com.service.impl;

import com.common.OperatorSession;
import com.common.OperatorSessionHelper;
import com.common.utils.MD5Utils;
import com.dao.BookrackGroupDao;
import com.dao.PermissionGroupDao;
import com.dao.SystemUserDao;
import com.dao.UserPermissionDao;
import com.entity.*;
import com.entity.param.OperatorParam;
import com.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZYL
 * @date 2018/11/28 10:54
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Value("${pwd.salt}")
    private String pwdSalt;
    @Autowired
    private SystemUserDao userDao;
    @Autowired
    private UserPermissionDao userPermissionDao;
    @Autowired
    private BookrackGroupDao bookrackGroupDao;
    @Autowired
    private PermissionGroupDao permissionGroupDao;


    /**
     * 用户登录
     *
     * @param param
     * @param request
     * @return
     * @author ZYL
     * @date 2018-11-28
     */
    @Override
    public boolean login(SystemUserEntity param, HttpServletRequest request) {
        boolean flag = false;
        if (param != null) {
            SystemUserEntity systemUserEntity = new SystemUserEntity();
            systemUserEntity.setUserLoginid(param.getUserLoginid());
            List<SystemUserEntity> systemUserEntities = userDao.queryAll(systemUserEntity);
            if (!systemUserEntities.isEmpty()) {
                //获取到实体类对象
                SystemUserEntity userEntity = systemUserEntities.get(0);
                String pwdMD5 = MD5Utils.md5(pwdSalt + param.getUserPassword());
                //判断密码是否正确
                if (pwdMD5.equals(userEntity.getUserPassword())) {
                    //密码正确,保存session
                    OperatorSession operatorSession = new OperatorSession(userEntity, new ArrayList<BookrackEntity>(), new ArrayList<SystemPermissionEntity>());
                    HttpSession session = request.getSession();
                    session.setAttribute(OperatorSession.SESSION_ID, operatorSession);
                    if (OperatorSessionHelper.saveSession(request)) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 根据管理员登录名或者用户名模糊查询
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-12-03
     */
    @Override
    public Map<String, Object> selectByParam(OperatorParam param) {
        Map<String, Object> map = new HashMap<>();
        if (param != null) {
            //模糊查询
            List<OperatorParam> params = userDao.selectByParam(param);
            if (params.size() > 0 && params != null) {
                //查询关联表的数据
                for (OperatorParam operatorParam : params) {
                    UserPermissionEntity userPermissionEntity = userPermissionDao.selectByPrimaryKey(operatorParam.getUserId());
                    if (userPermissionEntity != null) {
                        //获取书架组
                        BookrackGroupEntity bookrackGroupEntity = bookrackGroupDao.selectByPrimaryKey(userPermissionEntity.getRackgroupId());
                        //获取权限组
                        PermissionGroupEntity permissionGroupEntity = permissionGroupDao.selectByPrimaryKey(userPermissionEntity.getPergroupId());
                        operatorParam.setUserPermissionEntity(userPermissionEntity);
                        operatorParam.setPermissionGroupEntity(permissionGroupEntity);
                        operatorParam.setBookrackGroupEntity(bookrackGroupEntity);
                    }
                }
                map.put("rows", params);
            }
            //获取数量
            int total = userDao.countByParam(param);
            map.put("total", total);
            map.put("page", param.getPage().getPage());
            map.put("pageSize", param.getPage().getPageSize());
        }
        return map;
    }

    /**
     * 查询所有可用管理员信息
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-12-03
     */
    @Override
    public Map<String, Object> queryOperatorAll(OperatorParam param) {
        Map<String, Object> map = new HashMap<>();
        if (param != null) {
            //获取分页后的集合
            List<OperatorParam> params = userDao.selectByParam(param);
            if (params.size() > 0 && params != null) {
                //查询关联表的数据
                for (OperatorParam operatorParam : params) {
                    UserPermissionEntity userPermissionEntity = userPermissionDao.selectByPrimaryKey(operatorParam.getUserId());
                    if (userPermissionEntity != null) {
                        //获取书架组
                        BookrackGroupEntity bookrackGroupEntity = bookrackGroupDao.selectByPrimaryKey(userPermissionEntity.getRackgroupId());
                        //获取权限组
                        PermissionGroupEntity permissionGroupEntity = permissionGroupDao.selectByPrimaryKey(userPermissionEntity.getPergroupId());
                        operatorParam.setUserPermissionEntity(userPermissionEntity);
                        operatorParam.setBookrackGroupEntity(bookrackGroupEntity);
                        operatorParam.setPermissionGroupEntity(permissionGroupEntity);
                    }
                }
                map.put("rows", params);
            }
            //获取数量
            int total = userDao.countByParam(param);
            map.put("total", total);
            map.put("page", param.getPage().getPage());
            map.put("pageSize", param.getPage().getPageSize());
        }
        return map;
    }

    @Override
    public int updateOperatorInfo(OperatorParam param) {
        int result = 0;
        int result2 = 0;
        int result3 = 0;
        if (param != null) {
            BookrackGroupEntity bookRackGroup = param.getBookrackGroupEntity();
            PermissionGroupEntity permissionGroup = param.getPermissionGroupEntity();
            if (param.getUserPassword() != null && param.getUserPassword().length() > 0) {
//                    System.out.println(MD5Utils.md5(pwdSalt + param.getUserPassword()));
                //如果用户更新密码则加密
                param.setUserPassword(MD5Utils.md5(pwdSalt + param.getUserPassword()));
                //更新管理员表
                result = userDao.updateByPrimaryKey(param);
            }
            if (bookRackGroup != null) {
                //更新书架组
                result2 = bookrackGroupDao.updateByPrimaryKey(bookRackGroup);
            }
            if (permissionGroup != null) {
                //更新权限组
                result3 = permissionGroupDao.updateByPrimaryKey(permissionGroup);
            }
        }
        return result + result2 + result3;
    }

    @Override
    public int deleteOperator(OperatorParam param) {
        int delNum = 0;
        int delNum2 = 0;
        int delNum3 = 0;
        int delNum4 = 0;
        if (param != null) {
            //删除管理员
            delNum = userDao.deleteByPrimaryKey(param.getUserId());
            if (param.getUserPermissionEntity() != null) {
                //删除中间表的数据
                delNum2 = userPermissionDao.deleteByPrimaryKey(param.getUserPermissionEntity().getUserId());
            }
            if (param.getBookrackGroupEntity() != null) {
                //删除书架组
                delNum3 = bookrackGroupDao.deleteByPrimaryKey(param.getBookrackGroupEntity().getGroupId());
            }
            if (param.getPermissionGroupEntity() != null) {
                //删除权限组
                delNum4 = permissionGroupDao.deleteByPrimaryKey(param.getPermissionGroupEntity().getGroupId());
            }
        }
        return delNum + delNum2 + delNum3 + delNum4;
    }

    @Override
    public int addOperator(OperatorParam param) {
        int result = 0;
        int result2 = 0;
        int result3 = 0;
        int result4 = 0;
        if (param != null) {
            UserPermissionEntity userPermissionEntity = param.getUserPermissionEntity();
            BookrackGroupEntity bookRackGroup = param.getBookrackGroupEntity();
            PermissionGroupEntity permissionGroup = param.getPermissionGroupEntity();
            //添加管理员的时候给密码加密
            param.setUserPassword(MD5Utils.md5(pwdSalt + param.getUserPassword()));
            result = userDao.insert(param);
            if (userPermissionEntity != null) {
                result2 = userPermissionDao.insert(userPermissionEntity);
            }
            if (bookRackGroup != null) {
                result3 = bookrackGroupDao.insert(bookRackGroup);
            }
            if (permissionGroup != null) {
                result4 = permissionGroupDao.insert(permissionGroup);
            }
        }
        return result + result2 + result3 + result4;
    }
}
