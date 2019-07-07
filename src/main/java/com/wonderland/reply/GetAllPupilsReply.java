package com.wonderland.reply;

import com.wonderland.model.PupilInformation;

public class GetAllPupilsReply extends CommonReply{

	private java.util.List<PupilInformation> pupils;

	public java.util.List<PupilInformation> getPupils() {
		return pupils;
	}

	public void setPupils(java.util.List<PupilInformation> pupils) {
		this.pupils = pupils;
	}
	
	
}
