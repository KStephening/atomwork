/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TruckCompanyDAOImpl
 * Author:   zhangfan
 * Date:     2018/8/7 13:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.oarage.basedata.dao.impl;

import com.oarage.basedata.changeless.Constant;
import com.oarage.basedata.changeless.Status;
import com.oarage.basedata.dao.IDefaultDataPrivDAO;
import com.oarage.basedata.dao.ITruckCompanyDAO;
import com.oarage.basedata.entity.DefaultDataPriv;
import com.oarage.basedata.entity.TruckCompany;
import com.oarage.framework.dao.BaseDAO;
import com.oarage.privilege.business.service.IUserSession;
import com.oarage.privilege.entity.UserInfo;
import com.oarage.ssh.controller.IQueryCondition;
import com.oarage.ssh.hibernate.MysqlOrder;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 〈〉<br>
 *
 * @author Administrator
 * @create 2018/8/7
 * @since 1.0.0
 */
@Repository(value = "truckCompanyDAO")
public class TruckCompanyDAOImpl extends BaseDAO<TruckCompany, Long> implements ITruckCompanyDAO {

    @Resource(name = "userSession")
    private IUserSession userSession;

    @Resource(name = "defaultDataPrivDAO")
    private IDefaultDataPrivDAO defaultDataPrivDAO;

	@Override
	public TruckCompany get(Long id) {
		Criteria criterial=this.getSession().createCriteria(TruckCompany.class);
		criterial.add(Restrictions.eq("id",id));
		List<TruckCompany> truckCompanyList= criterial.list();
		TruckCompany truckCompany = null;
		if (truckCompanyList!=null) {
			truckCompany=truckCompanyList.get(0);
		}
		return truckCompany;
	}

	/**
	 * 根据id获取顶级的运输公司    不会检查公司的childCompany属性(用户是否有权限访问)
	 * @param id 公司的id
	 * @return
	 */
	public TruckCompany getTopTruckCompanyNotCheckDownLevel(Long id) {
		TruckCompany currentTruckCompany = get(id);
//		while (currentTruckCompany.getParentCompany() != null) {
//			currentTruckCompany = currentTruckCompany.getParentCompany();
//		}
		return currentTruckCompany;
	}

	/**
	 * 根据id获取顶级的运输公司  检查childCompany属性(用户是否有权限访问)
	 * @param id 公司的id
	 * @return
	 */
	@Override
	public TruckCompany getTopTruckCompany(Long id) {
		TruckCompany topTruckCompany = getTopTruckCompanyNotCheckDownLevel(id);
		List<Long> idList = getTruckCompanyIdList();
		Long isAdmin = idList.get(0);
//		判断是否是admin用户
		if (idList.get(0).equals(-1)){
			topTruckCompany = getDownLevelTruckCompanyNotCheckPriv(topTruckCompany);
		}else {
			topTruckCompany = getDownLevelTruckCompany(topTruckCompany, idList);
		}
		return topTruckCompany;
	}


	/**
	 * 使用回调的方式遍历运输公司，查询出一个公司的所有下层公司   不检查用户权限
	 * @param truckCompany
	 * @return
	 */
	public TruckCompany getDownLevelTruckCompanyNotCheckPriv(TruckCompany truckCompany){
		if (truckCompany.getChildCompany()!=null){
			for (TruckCompany truckCompany1:truckCompany.getChildCompany()){
				getDownLevelTruckCompanyNotCheckPriv(truckCompany1);
			}
		}
		return truckCompany;
	}

	/**
	 * 获取用户权限内的所有公司,一个顶级公司包含所有的下层公司
	 * @return  返回顶级公司的集合
	 */
	@Override
	public List<TruckCompany> getAllLayerTruckCompanies() {
		List<Long> idList = getTruckCompanyIdList();
		Long isAdmin = idList.get(0);
		TruckCompany topTruckCompany = null;
		List<TruckCompany> topTruckCompanyList = new ArrayList<>();
		List<TruckCompany> truckCompanyList = new ArrayList<>();
		//判断是否是管理员权限
		if (idList.get(0).equals(-1)){
//			status状态为1的顶级公司集合
			topTruckCompanyList = getAllTopTruckCompanies();
			for (TruckCompany truckCompany:topTruckCompanyList){
				truckCompanyList.add(getDownLevelTruckCompanyNotCheckPriv(truckCompany));
			}
		}else {
			//不会判断顶级公司的status状态
			//获取所有的顶级公司
			for (Long id : idList) {
				topTruckCompany = getTopTruckCompanyNotCheckDownLevel(id);
				if (topTruckCompany != null && !topTruckCompanyList.contains(topTruckCompany)) {
					topTruckCompanyList.add(topTruckCompany);
				}
			}
			//获取顶级公司下的子公司
			for (TruckCompany truckCompany : topTruckCompanyList) {
				truckCompanyList.add(getDownLevelTruckCompany(truckCompany, idList));
			}
		}
		return truckCompanyList;
	}

	/**
	 * 通过回调的方法    查询用户权限（idList）内一个公司所有下级公司
	 * @param truckCompany
	 * @param idList 用户权限内拥有的公司id集合
	 * @return
	 */
	public TruckCompany getDownLevelTruckCompany(TruckCompany truckCompany, List<Long> idList){
		int count = 0;
		int size = 0;
		if (truckCompany.getChildCompany() != null) {
			size = truckCompany.getChildCompany().size();
			for (TruckCompany truckCompany1 : truckCompany.getChildCompany()) {
				count++;
				if (idList.contains(truckCompany1.getId())) {
					getDownLevelTruckCompany(truckCompany1, idList);
				} else {
					truckCompany.getChildCompany().remove(truckCompany1);
					count--;
					size--;
				}
				if (count == size) {
					break;
				}
			}
		}

		return truckCompany;
	}

	/**
	 * 获取所有的顶级公司的集合  （status状态为1）
	 * @return
	 */
	public List<TruckCompany> getAllTopTruckCompanies() {
		Criteria criterial=this.getSession().createCriteria(TruckCompany.class);
		criterial.add(Restrictions.isNull("parentCompany.id"));
		criterial.add(Restrictions.eq("status.code",1));
		return (List<TruckCompany>)criterial.list();

	}

	/**
	 * 根据用户权限获取所能访问的id
	 * @return idList第一个存放的是    是否是admin   是 = -1   ;   否 = -2
	 */
	public List<Long> getTruckCompanyIdList(){
		List<Long> idList = new ArrayList<>();
		UserInfo userInfo = userSession.getCurrentThreadUser();
		// 根据userId查询出权限数据
		List<DefaultDataPriv> cDefaultDataPriv = defaultDataPrivDAO.getDefaultDataPrivByUserId2(new Long(userInfo.getId()).longValue());
		//判断是否是管理员
		if (userInfo.getUserName().equals(Constant.SYSTEM_ADMINISTRATOR)) {
			idList.add(-1L);
		}else {
//			如果不是admin   获取能够访问的id
			idList.add(-2L);
			TruckCompany tr = null;
			for (int i = 0; i < cDefaultDataPriv.size(); i++) {
				tr = getTruckCompanyByCode(cDefaultDataPriv.get(i).getScope());
				if (tr != null) {
					idList.add(tr.getId());
				}
			}
		}
		return idList;
	}


    @Override
    protected Criteria buildCriteria(Criteria criteria,
                                     IQueryCondition condition) {
        if (condition != null) {
            TruckCompany qc = (TruckCompany) condition;
            if (qc != null) {
                if (StringUtils.isNotEmpty(qc.getName())) {
                    criteria.add(Restrictions.like("name", "%"
                            + qc.getName().trim() + "%"));
                }
                if (qc.getStatus() != null && qc.getStatus().getCode() != null) {
                    criteria.add(Restrictions.eq("status.code", qc.getStatus()
                            .getCode()));
                }
                criteria.add(Restrictions.isNull("parentCompany"));
            }
        }
        criteria.addOrder(MysqlOrder.getOrder("name"));

        return criteria;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TruckCompany> getTruckCompany(TruckCompany truckComany) {
        Criteria criterial = this.getSession().createCriteria(
                TruckCompany.class);
        if (truckComany.getCompanyCode() != null) {
            criterial.add(Restrictions.eq("companyCode", truckComany
                    .getCompanyCode().trim()));
        }
        if (truckComany.getName() != null) {
            criterial
                    .add(Restrictions.eq("name", truckComany.getName().trim()));
        }
        if (truckComany.getShortName() != null) {
            criterial.add(Restrictions.eq("shortName",
                    truckComany.getShortName()));
        }
        if (truckComany.getId() != null) {
            criterial.add(Restrictions.ne("id", truckComany.getId()));
        }

        criterial.addOrder(MysqlOrder.getOrder("name"));
        super.builderDataPrivilegeCriteria(criterial, "id");
        return (List<TruckCompany>) criterial.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TruckCompany> getEffectiveComany() {
        UserInfo userInfo = userSession.getCurrentThreadUser();
        // 根据userId查询出权限数据
        List<DefaultDataPriv> cDefaultDataPriv = defaultDataPrivDAO.getDefaultDataPrivByUserId2(new Long(userInfo.getId()).longValue());
        TruckCompany tr = null;
        List<Long> orgSet = new ArrayList<Long>();
        for (int i = 0; i < cDefaultDataPriv.size(); i++) {
            tr = getTruckCompanyByCode(cDefaultDataPriv.get(i).getScope());
            if (tr != null) {
                orgSet.add(tr.getId());
            }
        }
        Criteria criterial = this.getSession().createCriteria(
                TruckCompany.class);
        criterial.add(Restrictions.eq("status.code", Status.USED));
        criterial.add(Restrictions.isNotNull("parentCompany.id"));
        criterial.addOrder(MysqlOrder.getOrder("name"));
        Iterator iterate = orgSet.iterator();
        Disjunction dis = Restrictions.disjunction();
        Long comid = null;
        while (iterate.hasNext()) {
            comid = (Long) iterate.next();
            // 如果Constant.SYSTEM_ADMINISTRATOR则为系统管理员
            if (!userInfo.getUserName().equals(Constant.SYSTEM_ADMINISTRATOR)) {
                dis.add(Restrictions.eq("id", comid));
                dis.add(Restrictions.eq("parentCompany.id", comid));
                criterial.add(dis);
            }

        }
        return (List<TruckCompany>) criterial.list();
    }

    @Override
    public TruckCompany getTruckCompanyByCode(String code) {
        Criteria criterial = this.getSession().createCriteria(
                TruckCompany.class);
        criterial.add(Restrictions.eq("companyCode", code));
        List<TruckCompany> list = criterial.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<TruckCompany> getCompanylist() {
        UserInfo userInfo = userSession.getCurrentThreadUser();
        // 根据userId查询出权限数据
        List<DefaultDataPriv> cDefaultDataPriv = defaultDataPrivDAO
                .getDefaultDataPrivByUserId2(new Long(userInfo.getId())
                        .longValue());

        TruckCompany tr = null;
        List<Long> orgSet = new ArrayList<Long>();
        for (int i = 0; i < cDefaultDataPriv.size(); i++) {
            tr = getTruckCompanyByCode(cDefaultDataPriv.get(i).getScope());
            if (tr != null) {
                orgSet.add(tr.getId());
            }
        }

        Criteria criterial = this.getSession().createCriteria(
                TruckCompany.class);
        criterial.add(Restrictions.eq("status.code", Status.USED));
        criterial.add(Restrictions.isNull("parentCompany.id"));
        criterial.addOrder(MysqlOrder.getOrder("name"));
        Iterator iterate = orgSet.iterator();
        Disjunction dis = Restrictions.disjunction();
        Long comid = null;
        while (iterate.hasNext()) {
            comid = (Long) iterate.next();
            // 如果Constant.SYSTEM_ADMINISTRATOR则为系统管理员
            if (!userInfo.getUserName().equals(Constant.SYSTEM_ADMINISTRATOR)) {
                dis.add(Restrictions.eq("id", comid));
                dis.add(Restrictions.eq("parentCompany.id", comid));
                criterial.add(dis);
            }
        }
        return (List<TruckCompany>) criterial.list();

    }

    /**
     * Description 通过公司名称查询公司ID
     * @param userRealName
     * @return
     * @see com.oarage.basedata.dao.ITruckCompanyDAO#findIdByName(String)
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<TruckCompany> findIdByName(String userRealName) {
        Criteria criterial = this.getSession().createCriteria(
                TruckCompany.class);
        criterial.add(Restrictions.eq("name", userRealName));
        return (List<TruckCompany>) criterial.list();
    }
    @Override
    public List<TruckCompany> getTruckCompanyByParentCompanyId(Long companyID) {
        Criteria criterial=this.getSession().createCriteria(TruckCompany.class);
        criterial.add(Restrictions.eq("id",companyID));
        criterial.add(Restrictions.isNull("parentCompany.id"));
        criterial.add(Restrictions.eq("status.code",1));
        // super.builderDataPrivilegeCriteria(criterial,"id");
        return (List<TruckCompany>)criterial.list();
    }
    @Override
    public List<TruckCompany> getAllStatusTruckCompany() {
        Criteria criterial=this.getSession().createCriteria(TruckCompany.class);
        criterial.add(Restrictions.isNull("parentCompany.id"));
        criterial.add(Restrictions.eq("status.code",1));
        return (List<TruckCompany>)criterial.list();
    }
}
