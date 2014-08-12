/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.softwarecatalog.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.softwarecatalog.model.SCProductEntry;
import com.liferay.portlet.softwarecatalog.model.SCProductEntryModel;
import com.liferay.portlet.softwarecatalog.model.SCProductEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SCProductEntry service. Represents a row in the &quot;SCProductEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.softwarecatalog.model.SCProductEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SCProductEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductEntryImpl
 * @see com.liferay.portlet.softwarecatalog.model.SCProductEntry
 * @see com.liferay.portlet.softwarecatalog.model.SCProductEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SCProductEntryModelImpl extends BaseModelImpl<SCProductEntry>
	implements SCProductEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s c product entry model instance should use the {@link com.liferay.portlet.softwarecatalog.model.SCProductEntry} interface instead.
	 */
	public static final String TABLE_NAME = "SCProductEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "productEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "tags", Types.VARCHAR },
			{ "shortDescription", Types.VARCHAR },
			{ "longDescription", Types.VARCHAR },
			{ "pageURL", Types.VARCHAR },
			{ "author", Types.VARCHAR },
			{ "repoGroupId", Types.VARCHAR },
			{ "repoArtifactId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SCProductEntry (productEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,type_ VARCHAR(75) null,tags VARCHAR(255) null,shortDescription STRING null,longDescription STRING null,pageURL STRING null,author VARCHAR(75) null,repoGroupId VARCHAR(75) null,repoArtifactId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SCProductEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY scProductEntry.modifiedDate DESC, scProductEntry.name DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SCProductEntry.modifiedDate DESC, SCProductEntry.name DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.softwarecatalog.model.SCProductEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.softwarecatalog.model.SCProductEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.softwarecatalog.model.SCProductEntry"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long REPOARTIFACTID_COLUMN_BITMASK = 4L;
	public static final long REPOGROUPID_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 32L;
	public static final long NAME_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SCProductEntry toModel(SCProductEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SCProductEntry model = new SCProductEntryImpl();

		model.setProductEntryId(soapModel.getProductEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());
		model.setTags(soapModel.getTags());
		model.setShortDescription(soapModel.getShortDescription());
		model.setLongDescription(soapModel.getLongDescription());
		model.setPageURL(soapModel.getPageURL());
		model.setAuthor(soapModel.getAuthor());
		model.setRepoGroupId(soapModel.getRepoGroupId());
		model.setRepoArtifactId(soapModel.getRepoArtifactId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SCProductEntry> toModels(SCProductEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SCProductEntry> models = new ArrayList<SCProductEntry>(soapModels.length);

		for (SCProductEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_NAME = "SCLicenses_SCProductEntries";
	public static final Object[][] MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_COLUMNS =
		{
			{ "licenseId", Types.BIGINT },
			{ "productEntryId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_SCLICENSES_SCPRODUCTENTRIES_SQL_CREATE =
		"create table SCLicenses_SCProductEntries (licenseId LONG not null,productEntryId LONG not null,primary key (licenseId, productEntryId))";
	public static final boolean FINDER_CACHE_ENABLED_SCLICENSES_SCPRODUCTENTRIES =
		GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.SCLicenses_SCProductEntries"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.softwarecatalog.model.SCProductEntry"));

	public SCProductEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SCProductEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SCProductEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productEntryId", getProductEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("tags", getTags());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("pageURL", getPageURL());
		attributes.put("author", getAuthor());
		attributes.put("repoGroupId", getRepoGroupId());
		attributes.put("repoArtifactId", getRepoArtifactId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productEntryId = (Long)attributes.get("productEntryId");

		if (productEntryId != null) {
			setProductEntryId(productEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		String pageURL = (String)attributes.get("pageURL");

		if (pageURL != null) {
			setPageURL(pageURL);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String repoGroupId = (String)attributes.get("repoGroupId");

		if (repoGroupId != null) {
			setRepoGroupId(repoGroupId);
		}

		String repoArtifactId = (String)attributes.get("repoArtifactId");

		if (repoArtifactId != null) {
			setRepoArtifactId(repoArtifactId);
		}
	}

	@JSON
	@Override
	public long getProductEntryId() {
		return _productEntryId;
	}

	@Override
	public void setProductEntryId(long productEntryId) {
		_productEntryId = productEntryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTags() {
		if (_tags == null) {
			return StringPool.BLANK;
		}
		else {
			return _tags;
		}
	}

	@Override
	public void setTags(String tags) {
		_tags = tags;
	}

	@JSON
	@Override
	public String getShortDescription() {
		if (_shortDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _shortDescription;
		}
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	@JSON
	@Override
	public String getLongDescription() {
		if (_longDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _longDescription;
		}
	}

	@Override
	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;
	}

	@JSON
	@Override
	public String getPageURL() {
		if (_pageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _pageURL;
		}
	}

	@Override
	public void setPageURL(String pageURL) {
		_pageURL = pageURL;
	}

	@JSON
	@Override
	public String getAuthor() {
		if (_author == null) {
			return StringPool.BLANK;
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
	}

	@JSON
	@Override
	public String getRepoGroupId() {
		if (_repoGroupId == null) {
			return StringPool.BLANK;
		}
		else {
			return _repoGroupId;
		}
	}

	@Override
	public void setRepoGroupId(String repoGroupId) {
		_columnBitmask |= REPOGROUPID_COLUMN_BITMASK;

		if (_originalRepoGroupId == null) {
			_originalRepoGroupId = _repoGroupId;
		}

		_repoGroupId = repoGroupId;
	}

	public String getOriginalRepoGroupId() {
		return GetterUtil.getString(_originalRepoGroupId);
	}

	@JSON
	@Override
	public String getRepoArtifactId() {
		if (_repoArtifactId == null) {
			return StringPool.BLANK;
		}
		else {
			return _repoArtifactId;
		}
	}

	@Override
	public void setRepoArtifactId(String repoArtifactId) {
		_columnBitmask |= REPOARTIFACTID_COLUMN_BITMASK;

		if (_originalRepoArtifactId == null) {
			_originalRepoArtifactId = _repoArtifactId;
		}

		_repoArtifactId = repoArtifactId;
	}

	public String getOriginalRepoArtifactId() {
		return GetterUtil.getString(_originalRepoArtifactId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SCProductEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SCProductEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SCProductEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SCProductEntryImpl scProductEntryImpl = new SCProductEntryImpl();

		scProductEntryImpl.setProductEntryId(getProductEntryId());
		scProductEntryImpl.setGroupId(getGroupId());
		scProductEntryImpl.setCompanyId(getCompanyId());
		scProductEntryImpl.setUserId(getUserId());
		scProductEntryImpl.setUserName(getUserName());
		scProductEntryImpl.setCreateDate(getCreateDate());
		scProductEntryImpl.setModifiedDate(getModifiedDate());
		scProductEntryImpl.setName(getName());
		scProductEntryImpl.setType(getType());
		scProductEntryImpl.setTags(getTags());
		scProductEntryImpl.setShortDescription(getShortDescription());
		scProductEntryImpl.setLongDescription(getLongDescription());
		scProductEntryImpl.setPageURL(getPageURL());
		scProductEntryImpl.setAuthor(getAuthor());
		scProductEntryImpl.setRepoGroupId(getRepoGroupId());
		scProductEntryImpl.setRepoArtifactId(getRepoArtifactId());

		scProductEntryImpl.resetOriginalValues();

		return scProductEntryImpl;
	}

	@Override
	public int compareTo(SCProductEntry scProductEntry) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				scProductEntry.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(scProductEntry.getName());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SCProductEntry)) {
			return false;
		}

		SCProductEntry scProductEntry = (SCProductEntry)obj;

		long primaryKey = scProductEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SCProductEntryModelImpl scProductEntryModelImpl = this;

		scProductEntryModelImpl._originalGroupId = scProductEntryModelImpl._groupId;

		scProductEntryModelImpl._setOriginalGroupId = false;

		scProductEntryModelImpl._originalCompanyId = scProductEntryModelImpl._companyId;

		scProductEntryModelImpl._setOriginalCompanyId = false;

		scProductEntryModelImpl._originalUserId = scProductEntryModelImpl._userId;

		scProductEntryModelImpl._setOriginalUserId = false;

		scProductEntryModelImpl._originalRepoGroupId = scProductEntryModelImpl._repoGroupId;

		scProductEntryModelImpl._originalRepoArtifactId = scProductEntryModelImpl._repoArtifactId;

		scProductEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SCProductEntry> toCacheModel() {
		SCProductEntryCacheModel scProductEntryCacheModel = new SCProductEntryCacheModel();

		scProductEntryCacheModel.productEntryId = getProductEntryId();

		scProductEntryCacheModel.groupId = getGroupId();

		scProductEntryCacheModel.companyId = getCompanyId();

		scProductEntryCacheModel.userId = getUserId();

		scProductEntryCacheModel.userName = getUserName();

		String userName = scProductEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			scProductEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			scProductEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			scProductEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			scProductEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			scProductEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		scProductEntryCacheModel.name = getName();

		String name = scProductEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			scProductEntryCacheModel.name = null;
		}

		scProductEntryCacheModel.type = getType();

		String type = scProductEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			scProductEntryCacheModel.type = null;
		}

		scProductEntryCacheModel.tags = getTags();

		String tags = scProductEntryCacheModel.tags;

		if ((tags != null) && (tags.length() == 0)) {
			scProductEntryCacheModel.tags = null;
		}

		scProductEntryCacheModel.shortDescription = getShortDescription();

		String shortDescription = scProductEntryCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			scProductEntryCacheModel.shortDescription = null;
		}

		scProductEntryCacheModel.longDescription = getLongDescription();

		String longDescription = scProductEntryCacheModel.longDescription;

		if ((longDescription != null) && (longDescription.length() == 0)) {
			scProductEntryCacheModel.longDescription = null;
		}

		scProductEntryCacheModel.pageURL = getPageURL();

		String pageURL = scProductEntryCacheModel.pageURL;

		if ((pageURL != null) && (pageURL.length() == 0)) {
			scProductEntryCacheModel.pageURL = null;
		}

		scProductEntryCacheModel.author = getAuthor();

		String author = scProductEntryCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			scProductEntryCacheModel.author = null;
		}

		scProductEntryCacheModel.repoGroupId = getRepoGroupId();

		String repoGroupId = scProductEntryCacheModel.repoGroupId;

		if ((repoGroupId != null) && (repoGroupId.length() == 0)) {
			scProductEntryCacheModel.repoGroupId = null;
		}

		scProductEntryCacheModel.repoArtifactId = getRepoArtifactId();

		String repoArtifactId = scProductEntryCacheModel.repoArtifactId;

		if ((repoArtifactId != null) && (repoArtifactId.length() == 0)) {
			scProductEntryCacheModel.repoArtifactId = null;
		}

		return scProductEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{productEntryId=");
		sb.append(getProductEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", longDescription=");
		sb.append(getLongDescription());
		sb.append(", pageURL=");
		sb.append(getPageURL());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", repoGroupId=");
		sb.append(getRepoGroupId());
		sb.append(", repoArtifactId=");
		sb.append(getRepoArtifactId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.softwarecatalog.model.SCProductEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>productEntryId</column-name><column-value><![CDATA[");
		sb.append(getProductEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tags</column-name><column-value><![CDATA[");
		sb.append(getTags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDescription</column-name><column-value><![CDATA[");
		sb.append(getLongDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageURL</column-name><column-value><![CDATA[");
		sb.append(getPageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repoGroupId</column-name><column-value><![CDATA[");
		sb.append(getRepoGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repoArtifactId</column-name><column-value><![CDATA[");
		sb.append(getRepoArtifactId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = SCProductEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SCProductEntry.class
		};
	private long _productEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _type;
	private String _tags;
	private String _shortDescription;
	private String _longDescription;
	private String _pageURL;
	private String _author;
	private String _repoGroupId;
	private String _originalRepoGroupId;
	private String _repoArtifactId;
	private String _originalRepoArtifactId;
	private long _columnBitmask;
	private SCProductEntry _escapedModel;
}