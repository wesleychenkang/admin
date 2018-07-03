package com.vanggame.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.ChannelMasterDao;
import com.vanggame.admin.entity.ChannelMaster;

@Service
public class ChannelMasterService {

	@Autowired
	private ChannelMasterDao channelMasterDao;

	public List<ChannelMaster> getAllChannelMaster(Integer channel_id, String channel_Name, Integer pageNo,
			Integer pageSize) {

		Integer firstIndex = null;
		Integer lastIndex = null;
		if (null != pageNo && null != pageSize) {
			firstIndex = (pageNo - 1) * pageSize;
			lastIndex = pageNo * pageSize;
		}
		List<ChannelMaster> list = channelMasterDao.queryChannelMaseter(channel_id, channel_Name, firstIndex,
				lastIndex);
		// for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		// ChannelMaster channelMaster = (ChannelMaster) iterator.next();
		// if (null == channelMaster) {
		// System.out.println("null====null 为何辣么多null null还能查出来");
		// } else {
		// Integer chaId = channelMaster.getChannelId();
		// if (chaId != null) {
		// System.out.println("chaId");
		// } else {
		// System.out.println("chaId null");
		// }
		// }
		//
		// }
		return list;
	}

	public void saveChannelMaster(ChannelMaster channelMaster) {
		List<ChannelMaster> list = channelMasterDao.queryChannelMaseter(channelMaster.getChannelId(), null, null, null);
		if (list.isEmpty() && list.size() == 0) {
			channelMasterDao.saveMaster(channelMaster);
		} else {
			// 需要做更新操作

			channelMasterDao.updateMaster(channelMaster);
		}

	}

	public void removeChannelMaster(Integer channelMasterId) {
		channelMasterDao.deleteMaster(channelMasterId);
	}
}
