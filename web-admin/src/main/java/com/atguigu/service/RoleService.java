package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import com.atguigu.entity.Role;
import com.atguigu.service.BaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface RoleService extends BaseService<Role> {

    List<Role> findAll();

}
