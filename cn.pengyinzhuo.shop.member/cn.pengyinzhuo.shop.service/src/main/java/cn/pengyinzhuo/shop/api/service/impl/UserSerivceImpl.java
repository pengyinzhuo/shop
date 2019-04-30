package cn.pengyinzhuo.shop.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;

import cn.pengyinzhuo.shop.api.entity.User;
import cn.pengyinzhuo.shop.api.service.IUserService;
import cn.pengyinzhuo.shop.common.api.ShopResult;
import cn.pengyinzhuo.shop.common.constants.DBTableName;
import cn.pengyinzhuo.shop.dao.IUserDAO;
import cn.pengyinzhuo.shop.utils.DateUtils;
import cn.pengyinzhuo.shop.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class UserSerivceImpl implements IUserService{


	@Autowired
	private IUserDAO userDao;
	
	@Override
	public ShopResult regist(@RequestBody User user) {
		if(StringUtils.isEmpty(user.getUserName())) {
			return ShopResult.build(400,"用户名不能为空");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			return ShopResult.build(400, "密码不能为空");
		}
		try {
			
			user.setCreated(DateUtils.getTimestamp());
			user.setUpdated(DateUtils.getTimestamp());
			String phone = user.getPhone();
			String password = user.getPassword();
			user.setPassword(mdhPassSalt(phone, password));
			userDao.save(user, DBTableName.TABLE_MB_USER);
			return ShopResult.ok();
		}catch (Exception e){
			log.error("###regist() ERROR:",e);
			return ShopResult.build(500, "注册失败");
		}
	}

	
	
	public String mdhPassSalt(String phone,String password) {
		String newPass = MD5Util.MD5(phone+password);
		return newPass;
	}
	
}
