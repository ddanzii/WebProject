package com.eunji.fanfare.vo;

import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
public class UserVO {
	// invoke : 객체의 이름을 찾는 것, 객체에 해당하는 이름을 가져오기 위해서 사용,
	// 변수명과 일치하는 객체 찾아서 변수값을 할당한 후 객체로 만들기까지 함
	public String u_id; 
	public String u_pw;
	public String u_hp;
	public String a_addr;
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if (obj instanceof UserVO) {
				UserVO vo = (UserVO)obj;
				return vo.u_id.equals(this.u_id);
			}
		}
		//원래 나와 obj의 hash값 비교
		return false;
	}
}
