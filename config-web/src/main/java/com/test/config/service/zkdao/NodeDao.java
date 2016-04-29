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

import java.util.List;

import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.utils.ZKPaths;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.test.config.service.entity.PropertyItem;

/**
 * @author <a href="mailto:wangyuxuan@dangdang.com">Yuxuan Wang</a>
 * 
 */
public class NodeDao extends BaseDao implements INodeDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<PropertyItem> findProperties(String node) {
		List<PropertyItem> properties = Lists.newArrayList();
		try {
			GetChildrenBuilder childrenBuilder = getClient().getChildren();
			List<String> children = childrenBuilder.forPath(node);
			GetDataBuilder dataBuilder = getClient().getData();
			if (children != null) {
				for (String child : children) {
					String propPath = ZKPaths.makePath(node, child);
					PropertyItem item = new PropertyItem(child, new String(dataBuilder.forPath(propPath), Charsets.UTF_8));
					item.setOriName(child);
					properties.add(item);
				}
			}
		} catch (Exception e) {
			Throwables.propagate(e);
		}
		return properties;
	}

	@Override
	public List<String> listChildren(String node) {
		List<String> children = Lists.newArrayList();
		try {
			GetChildrenBuilder childrenBuilder = getClient().getChildren();
			children = childrenBuilder.forPath(node);
		} catch (Exception e) {
			Throwables.propagate(e);
		}
		return children;
	}

}
