package com.atguigu.service.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.RoleDao;
import com.atguigu.service.RoleService;
import com.atguigu.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl <Role> implements RoleService {
//   @Autowired
    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    protected BaseDao<Role> getEntityDao() {
        return this.roleDao;
    }

//    @Override
//    public PageInfo<Role> findPage(Map<String, Object> filters) {
//        int pageNum = CastUtil.castInt(filters.get("pageNum"),1);
//        int pageSize = CastUtil.castInt(filters.get("pageSize"),10);
////        开启分页插件
//        PageHelper.startPage(pageNum,pageSize);
////        调用分页的和 查询条件的方法
//        Page<Role> page=roleDao.findPage(filters);
////        第二个参数是显示多少个页码数
//        return new PageInfo<>(page,5);
//    }
}
