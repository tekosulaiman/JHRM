package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstMembership;

public interface MstMembershipDAO {
	public void save(MstMembership mstMembership);
    public void update(MstMembership mstMembership);
    public void saveOrUpdate(MstMembership mstMembership);
    public void delete(MstMembership mstMembership);
    public List<MstMembership> getAllMstMembership();
}
