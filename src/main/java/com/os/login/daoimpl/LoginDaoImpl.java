package com.os.login.daoimpl;

import com.os.bean.PostInfo;
import com.os.bean.UserInfo;
import com.os.login.dao.LoginDao;
import com.os.utils.SysDB;
import com.os.utils.SysNumber;
import com.os.utils.SysString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录业务
 * Created by xhc on 2017/3/28.
 */
@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * 获得用户信息
     *
     * @param sUserCode 用户代码
     * @return
     */
    public UserInfo getUser(String sUserCode) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        sb.append("select u.fCode,u.fLoginCode,u.fName fUserName,u.fDeptCode,u.fOrgCode,u.fPassword,u.fDataRange,u.fIsStop");
        sb.append(",(select fName from s_DepartMent where fCode=u.fDeptCode) fDeptName ");
        sb.append(",(select fName from s_DepartMent where fCode=u.fOrgCode) fOrgName ");
        sb.append(" from s_user u");
        sb.append(" where u.fCode=:code");
        //获得用户登录信息
        HashMap<String, Object> p = new HashMap<String, Object>();
        p.put("code", sUserCode);
        Map<String, Object> m = SysDB.getMapValue(jdbcTemplate, sb.toString(), p);
        UserInfo userInfo = new UserInfo();

        userInfo.setUserCode(SysString.getMapStr(m, "fCode"));
        userInfo.setLoginCode(SysString.getMapStr(m, "fLoginCode"));
        userInfo.setUserName(SysString.getMapStr(m, "fUserName"));
        userInfo.setPassword(SysString.getMapStr(m, "fPassword"));
        userInfo.setDeptCode(SysString.getMapStr(m, "fDeptCode"));
        userInfo.setDeptName(SysString.getMapStr(m, "fDeptName"));
        userInfo.setOrgCode(SysString.getMapStr(m, "fOrgCode"));
        userInfo.setOrgName(SysString.getMapStr(m, "fOrgName"));
        userInfo.setDataRange(SysString.getMapStr(m,"fDataRange"));
        userInfo.setIsStop(SysNumber.getMapInt(m,"fIsStop")==1?true:false);
        //获得用户岗位
        sb = new StringBuilder();
        sb.append(" select t.fpostcode code,p.fname name from s_userpost t");
        sb.append(" left join s_post p on t.fpostcode=p.fcode ");
        sb.append(" where t.fusercode=:code ");
        List<PostInfo> postList = SysDB.getRows(jdbcTemplate, sb.toString(), new Object[]{sUserCode},PostInfo.class);
        //设置用户岗位
        if (postList != null && !postList.isEmpty())
        {
            userInfo.setUserPosts(postList);
        }
        return userInfo;
    }

    /**
     * 获得岗位模块权限
     * @param posts
     * @return
     * @throws Exception
     */
    public List<String> getPostModels(List<String> posts)
    throws Exception{
        List<String> permissions=null;
        StringBuilder sb=new StringBuilder();
        

	        MapSqlParameterSource param;
	        if(!SysString.isEmpty(posts)){
				sb.append(" select v.fmodelcode||':'||v.fOpID fPermission from (");
	        sb.append("     select p.fmodelcode,p.fopid,p.fopname");
	        sb.append("     ,(select max(fopid) from s_postright where p.fmodelcode=fmodelcode ");
	        if(posts==null || posts.isEmpty()){
	            sb.append(") fSumOp");
	        }else{
	            sb.append(" and fpostcode in(:postcode)) fSumOp ");
	        }
	        sb.append(" from s_modelop p ");
	        sb.append(" where exists(select 1 from s_postright where fmodelcode=p.fmodelcode ");
	        if(posts==null || posts.isEmpty()){
	            sb.append(" )");
	        }else{
	            sb.append(" and fpostcode in(:postcode) )");
	        }
	        sb.append(" ) v where bitand(v.fsumop,v.fopid)=v.fopid");
            param=new MapSqlParameterSource();
            param.addValue("postcode",posts);
        }else{
            sb.append("select fmodelcode || ':' || fOpID fPermission");
            sb.append(" from  s_modelop ");
            param=new MapSqlParameterSource();
        }
        sb.append(" order by 1 ");
        permissions= SysDB.getStrList(jdbcTemplate,sb.toString(),param);
        return permissions;
    }
}
