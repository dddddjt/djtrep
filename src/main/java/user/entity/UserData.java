package user.entity;

import java.util.ArrayList;
import java.util.List;

public class UserData {

	public static List in() {
		User user1=new User("1","张三","20","男","2019-01-01","杭州");
		User user2=new User("2","李四","21","男","2019-01-02","温州");
		User user3=new User("3","王五","22","女","2019-01-03","台州");
		List<User> list=new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
	
}
