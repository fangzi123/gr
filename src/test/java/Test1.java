import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.cyou.gr.entity.vo.UserVo;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserVo user=new UserVo();
	    	user.setName("wff@cy");
	    	user.setPassword("123456");
	    	
	    	String newPassword = new SimpleHash(
	                "md5",
	                user.getPassword(),
	                ByteSource.Util.bytes(user.getName()),
	                2).toHex();

	    	
	    	System.out.println(newPassword);
	}

}
