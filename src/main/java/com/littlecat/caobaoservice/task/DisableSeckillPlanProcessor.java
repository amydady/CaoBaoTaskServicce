package com.littlecat.caobaoservice.task;

import java.util.TimerTask;

import com.littlecat.cbb.rest.RestClient;

public class DisableSeckillPlanProcessor extends TimerTask
{
	protected static final String SECKILLPLAN_ENABLE_PROCESS_SERVICE_PATH = "http://localhost:8006/rest/littlecat/caobao/seckillplan/task/disable";

	@Override
	public void run()
	{
		RestClient.get(SECKILLPLAN_ENABLE_PROCESS_SERVICE_PATH);
	}
}
