package com.littlecat.caobaoservice.sysparam;

import org.codehaus.jackson.type.TypeReference;

import com.littlecat.cbb.exception.LittleCatException;
import com.littlecat.cbb.rest.RestClient;
import com.littlecat.cbb.rest.RestRsp;
import com.littlecat.cbb.rest.RestfulRequestParam;
import com.littlecat.cbb.utils.CollectionUtil;
import com.littlecat.cbb.utils.JsonUtil;

public final class SysParamUtil
{
	private static final String SYSPARAM_SERVICE_PATH = "http://localhost:8006/rest/littlecat/caobao/sys/param/getValueByName?name= {name}";
	private static final String FIELDNAME_SYSPARAM_NAME = "name";

	private SysParamUtil()
	{
	}

	public static String getValueByName(String name) throws LittleCatException
	{
		RestfulRequestParam reqParam = new RestfulRequestParam();
		reqParam.getReqParam().put(FIELDNAME_SYSPARAM_NAME, name);

		RestRsp<String> rsp = JsonUtil.fromJson(RestClient.get(SYSPARAM_SERVICE_PATH, reqParam), new TypeReference<RestRsp<String>>()
		{
		});

		if (rsp == null || CollectionUtil.isEmpty(rsp.getData()))
		{
			throw new LittleCatException("get system param error,param name:" + name);
		}

		return rsp.getData().get(0);
	}
}
