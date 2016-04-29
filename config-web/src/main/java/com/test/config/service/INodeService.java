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
package com.test.config.service;

import java.util.List;

import com.test.config.service.entity.PropertyItem;

public interface INodeService {
	
	List<PropertyItem> findProperties(String node);
	
	List<String> listChildren(String node);
	
	boolean createProperty(String nodeName, String value);

	boolean updateProperty(String nodeName, String value);

	void deleteProperty(String nodeName);
}
