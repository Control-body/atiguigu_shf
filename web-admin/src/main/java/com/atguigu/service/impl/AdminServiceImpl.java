package com.atguigu.service.impl;

import com.atguigu.dao.AdminDao;
import com.atguigu.dao.BaseDao;
import com.atguigu.entity.Admin;
import com.atguigu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    protected BaseDao<Admin> getEntityDao() {
        return this.adminDao;
    }


}
