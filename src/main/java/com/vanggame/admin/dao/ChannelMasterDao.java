package com.vanggame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vanggame.admin.entity.ChannelMaster;

public interface ChannelMasterDao {

	public void saveMaster(ChannelMaster channelMaster);

	public void deleteMaster(Integer tid);

	public List<ChannelMaster> query();

	public List<ChannelMaster> queryChannelMaseter(@Param("channelId") Integer channelId,
			@Param("channelName") String channelName,@Param("currIndex") Integer currIndex, @Param("pageSize") Integer pageSize);

	public Integer queryAllMasterCount();
	
	public void updateMaster(ChannelMaster master);
}
