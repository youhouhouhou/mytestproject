/**
 * Copyright 1999-2014 dangdang.com.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.config.service.zkdao;

/**
 * 用户授权、验证相关数据访问
 * 
 * @author <a href="mailto:wangyuxuan@dangdang.com">Yuxuan Wang</a>
 *
 */
public interface IAuthDao {

	/**
	 * 检查授权
	 * 
	 * @param nodeName
	 * @param password
	 * @return
	 */
	boolean checkAuth(String nodeName, String password);

	/**
	 * 授权
	 * 
	 * @param nodeName
	 * @param password
	 * @return true: 授权成功; false: 节点已被授权
	 */
	boolean auth(String nodeName, String password);

}
