package com.littlecat.caobaoservice.task;

import java.util.TimerTask;

import com.littlecat.cbb.rest.RestClient;

public class ClearResLockProcessor extends TimerTask
{
	protected static final String CLEAR_RESLOCK_PROCESS_SERVICE_PATH = "http://localhost:8006/rest/littlecat/caobao/reslock/clear";

	@Override
	public void run()
	{
		RestClient.get(CLEAR_RESLOCK_PROCESS_SERVICE_PATH);
	}
}
