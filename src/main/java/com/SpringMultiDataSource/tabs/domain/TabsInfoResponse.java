package com.SpringMultiDataSource.tabs.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "TabsInfoResponse.getInfo", procedureName = "TCS.ISN_GET_WP_INFO", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "s_subno", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_USED_ON_MIN", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_FREE_ON_MIN", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_USED_OFF_MIN", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_FREE_OFF_MIN", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_USED_GPRS", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_FREE_GPRS", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_USED_SMS", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "S_FREE_SMS", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "ERROR_CODE", type = Integer.class) })
public class TabsInfoResponse {
	@Id
	private long id;
}
