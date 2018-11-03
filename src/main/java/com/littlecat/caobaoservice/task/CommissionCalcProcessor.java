package com.littlecat.caobaoservice.task;

import java.util.TimerTask;

import com.littlecat.cbb.rest.RestClient;

public class CommissionCalcProcessor extends TimerTask
{
	protected static final String COMMISSIONCALC_PROCESS_SERVICE_PATH = com.littlecat.caobaoservice.common.Consts.SERVICEBASEURL_CAOBAO + "/commission/calc/doCalc";

	@Override
	public void run()
	{
		RestClient.get(COMMISSIONCALC_PROCESS_SERVICE_PATH);
	}
}
