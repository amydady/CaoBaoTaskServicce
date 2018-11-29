package com.littlecat.caobao.taskservice.task;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecat.caobao.taskservice.common.TaskServiceConsts;
import com.littlecat.cbb.common.Consts;
import com.littlecat.cbb.rest.RestClient;
import com.littlecat.cbb.rest.RestSimpleRsp;
import com.littlecat.cbb.utils.JsonUtil;

public class CommissionCalcProcessor extends TimerTask
{
	protected static final String COMMISSIONCALC_PROCESS_SERVICE_PATH = TaskServiceConsts.CAOBAO_SERVICE_URLBASE + "/commission/calc/doCalc";
	private static final Logger logger = LoggerFactory.getLogger(CommissionCalcProcessor.class);

	@Override
	public void run()
	{
		// logger.error("CommissionCalc begin:" +
		// DateTimeUtil.getCurrentTimeForDisplay());
		RestSimpleRsp rsp = JsonUtil.fromJson(RestClient.get(COMMISSIONCALC_PROCESS_SERVICE_PATH), RestSimpleRsp.class);

		if (!Consts.ERROR_CODE_NONE.equals(rsp.getCode()))
		{
			logger.error(rsp.getMessage());
		}

		// logger.error("CommissionCalc end:" +
		// DateTimeUtil.getCurrentTimeForDisplay());

	}
}
