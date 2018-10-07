package com.littlecat.caobaoservice.task;

import java.util.Timer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.littlecat.caobaoservice.sysparam.SysParamUtil;
import com.littlecat.cbb.common.Consts;
import com.littlecat.cbb.utils.StringUtil;

/**
 * 系统的任务管理器
 * 
 * @author amydady
 *
 */
@Component
public class TaskMgr
{
	private static final Logger logger = LoggerFactory.getLogger(TaskMgr.class);

	// 定时任务默认启动延时（毫秒）
	private static final long TASK_DELAY_DEFAULT = 1000;

	// 秒杀计划按秒杀时间窗口定时处理失效标记的周期（秒）
	private static final long SECKILLPLAN_ENABLETAG_PROCESS_CYC_DEFAULT = 5 * 60;

	// 资源锁定期清理周期（秒）
	private static final long CLEAR_RESLOCK_PROCESS_CYC_DEFAULT = 1 * 60;

	@PostConstruct
	public void init()
	{
		try
		{
			startTask4DisableSecKillPlan();
			startTask4ClearResLock();
		}
		catch (Exception e)
		{
			logger.error("TaskMgr init error.", e);
		}
	}

	/**
	 * 定时将秒杀计划置失效
	 */
	private void startTask4DisableSecKillPlan()
	{
		long cyc = SECKILLPLAN_ENABLETAG_PROCESS_CYC_DEFAULT;
		String cycFromParam = SysParamUtil.getValueByName(Consts.PARAM_NAME_SECKILLPLAN_ENABLETAG_PROCESS_CYC);
		if (StringUtil.isNotEmpty(cycFromParam))
		{
			cyc = Long.valueOf(cycFromParam);
		}

		// 固定时延启动，固定周期执行
		new Timer().schedule(new DisableSeckillPlanProcessor(), TASK_DELAY_DEFAULT, cyc * 1000);
	}

	/**
	 * 定时清理资源锁
	 */
	private void startTask4ClearResLock()
	{
		long cyc = CLEAR_RESLOCK_PROCESS_CYC_DEFAULT;
		String cycFromParam = SysParamUtil.getValueByName(Consts.PARAM_NAME_CLEAR_RESLOCK_PROCESS_CYC);
		if (StringUtil.isNotEmpty(cycFromParam))
		{
			cyc = Long.valueOf(cycFromParam);
		}

		// 固定时延启动，固定周期执行
		new Timer().schedule(new ClearResLockProcessor(), TASK_DELAY_DEFAULT, cyc * 1000);
	}
}
