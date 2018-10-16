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

	/**
	 * 根据id获取顶级的运输公司
	 * @param id 公司的id
	 * @return
	 */
	public TruckCompany getTopTruckCompanies(Long id) {
		TruckCompany currentTruckCompany = get(id);
		if (currentTruckCompany!=null) {
			while (currentTruckCompany.getParentCompany() != null) {
				currentTruckCompany = currentTruckCompany.getParentCompany();
			}
		}
		return currentTruckCompany;
	}

	public TruckCompany getAllLevelTruckCompanies(Long id){
		TruckCompany truckCompany = getTopTruckCompanies(id);
		if (truckCompany!=null) {
			truckCompany = getDownLevelTruckCompaniesUtil(truckCompany);
		}
		return truckCompany;
	}

	public TruckCompany getDownLevelTruckCompanies(Long id){
		TruckCompany truckCompany = get(id);
		if (truckCompany!=null) {
			truckCompany = getDownLevelTruckCompaniesUtil(truckCompany);
		}
		return truckCompany;
	}

	/**
	 * 使用回调的方式遍历运输公司，查询出所有的子公司
	 * @param truckCompany
	 * @return
	 */
	public TruckCompany getDownLevelTruckCompaniesUtil(TruckCompany truckCompany){
		if (truckCompany.getChildCompany()!=null){
			for (TruckCompany truckCompany1:truckCompany.getChildCompany()){
				getDownLevelTruckCompaniesUtil(truckCompany1);
			}
		}
		return truckCompany;
	}

	@Override
	public TruckCompany getTruckCompanyLevel(Long id) {
		TruckCompany currentTruckCompany = get(id);
		TruckCompany truckCompanyTemp = currentTruckCompany.getParentCompany();
		//获取上层公司
		while (truckCompanyTemp!=null){
			truckCompanyTemp=truckCompanyTemp.getParentCompany();
		}

		return null;
	}


	public List<TruckCompany> getAllLayerTruckCompanies() {
		List<Long> idList = getIdList();
		TruckCompany topTruckCompany = null;
		List<TruckCompany> truckCompanyList = new ArrayList<>();
		//获取所有的顶级公司
		for (Long id :idList){
			topTruckCompany = getTopTruckCompanies(id);
			if (topTruckCompany!=null) {
				truckCompanyList.add(topTruckCompany);
			}
		}
		//获取顶级公司下的子公司


		return super.getAll();
	}

	public TruckCompany getDownLevelTruckCompaniesUtilTwo(TruckCompany truckCompany,List<Long> idList){
		List<TruckCompany> truckCompanyList = new ArrayList<>();
		if (truckCompany.getChildCompany()!=null){

			for (TruckCompany truckCompany1:truckCompany.getChildCompany()){
				if (idList.contains(truckCompany1.getId())) {
					getDownLevelTruckCompaniesUtil(truckCompany1);
				}else {
					truckCompanyList = truckCompany.getChildCompany();
					truckCompanyList.remove(truckCompany1);
				}
			}
		}
		return truckCompany;
	}

	/**
	 * 根据用户权限获取所能访问的id
	 * @return idList第一存放的是    是否是admin   是=1   否=0
	 */
	public List<Long> getIdList(){
		List<Long> idList = new ArrayList<>();
		UserInfo userInfo = userSession.getCurrentThreadUser();
		// 根据userId查询出权限数据
		List<DefaultDataPriv> cDefaultDataPriv = defaultDataPrivDAO.getDefaultDataPrivByUserId2(new Long(userInfo.getId()).longValue());
		//判断是否是管理员
		if (userInfo.getUserName().equals(Constant.SYSTEM_ADMINISTRATOR)) {
			idList.add(1L);
		}else {
//			如果不是admin   获取能够访问的id
			idList.add(0L);
			TruckCompany tr = null;
			List<Long> orgSet = new ArrayList<Long>();
			for (int i = 0; i < cDefaultDataPriv.size(); i++) {
				tr = getTruckCompanyByCode(cDefaultDataPriv.get(i).getScope());
				if (tr != null) {
					orgSet.add(tr.getId());
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
