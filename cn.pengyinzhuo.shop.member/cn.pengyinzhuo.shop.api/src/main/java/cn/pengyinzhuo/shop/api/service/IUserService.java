package cn.pengyinzhuo.shop.api.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pengyinzhuo.shop.api.entity.User;
import cn.pengyinzhuo.shop.common.api.ShopResult;

@RequestMapping("member")
public interface IUserService {

	/**
	 * 
	 * @methodDesc:功能描述:(注册服务)
	 * @param: @param
	 * 				User
	 * @param: @return
	 */
	@PostMapping("/regist")
	public ShopResult regist(@RequestBody User user);
}
