package com.littlecat.caobao.taskservice.task;

import java.util.TimerTask;

import com.littlecat.caobao.taskservice.common.TaskServiceConsts;
import com.littlecat.cbb.rest.RestClient;

public class CommissionCalcProcessor extends TimerTask
{
	protected static final String COMMISSIONCALC_PROCESS_SERVICE_PATH = TaskServiceConsts.CAOBAO_SERVICE_URLBASE + "/commission/calc/doCalc";

	@Override
	public void run()
	{
		RestClient.get(COMMISSIONCALC_PROCESS_SERVICE_PATH);
	}
}
