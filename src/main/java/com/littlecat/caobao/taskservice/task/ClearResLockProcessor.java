package com.littlecat.caobao.taskservice.task;

import java.util.TimerTask;

import com.littlecat.caobao.taskservice.common.TaskServiceConsts;
import com.littlecat.cbb.rest.RestClient;

public class ClearResLockProcessor extends TimerTask
{
	protected static final String CLEAR_RESLOCK_PROCESS_SERVICE_PATH = TaskServiceConsts.CAOBAO_SERVICE_URLBASE + "/reslock/clear";

	@Override
	public void run()
	{
		RestClient.get(CLEAR_RESLOCK_PROCESS_SERVICE_PATH);
	}
}
