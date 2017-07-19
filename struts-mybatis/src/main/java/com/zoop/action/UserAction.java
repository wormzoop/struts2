package com.zoop.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = -7262966706665445470L;
	
	private String result;
	
	public String execute() throws Exception{
		return SUCCESS;
	}

	public String jsonexec() throws Exception{
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "111");
		map.put("name", "jiji");
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("id", "111");
		map1.put("name", "jiji");
		list.add(map);
		list.add(map1);
		JSONArray jsonArray = JSONArray.fromObject(list);
		setResult(jsonArray.toString());
		return SUCCESS;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
}
