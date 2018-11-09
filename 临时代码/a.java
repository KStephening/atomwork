public List<GpsTrackInfo> query(GpsTrackInfo track) {
		List<GpsTrackInfo> result;
		try {
			StringBuffer sql = new StringBuffer("SELECT ID AS id, CONSOLE_CODE AS consoleCode, SIGN_CODE AS signCode, TRUCK_ID AS truckId, TIME_ZONE AS timeZone,");
			sql.append("TRACK_DATE AS trackDate, INSERT_TIME AS insertTime, TRACK AS track from " + track.getSignCode());
			//注意不是isNotEmpty
			if (StringUtils.isNotEmpty(track.getStartTime()) && StringUtils.isNotEmpty(track.getEndTime())) {
				sql.append(" where TRACK_DATE>='" + track.getStartTime().substring(0, 10) + "'");
				sql.append(" and TRACK_DATE<='" + track.getEndTime().substring(0, 10) + "'");
			} else if (StringUtils.isNotEmpty(track.getStartTime()) && StringUtils.isEmpty(track.getEndTime())) {
				sql.append(" where TRACK_DATE='" + track.getStartTime().substring(0, 10) + "'");
			}
			SQLQuery sqlQuery = this.getSession().createSQLQuery(sql.toString());
			sqlQuery.addScalar("id", StandardBasicTypes.LONG);
			sqlQuery.addScalar("consoleCode", StandardBasicTypes.STRING);
			sqlQuery.addScalar("signCode", StandardBasicTypes.STRING);
			sqlQuery.addScalar("truckId", StandardBasicTypes.INTEGER);
			sqlQuery.addScalar("timeZone", StandardBasicTypes.STRING);
			sqlQuery.addScalar("trackDate", StandardBasicTypes.STRING);
			sqlQuery.addScalar("insertTime", StandardBasicTypes.TIMESTAMP);
			sqlQuery.addScalar("track", StandardBasicTypes.STRING);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(GpsTrackInfo.class));
			result = sqlQuery.list();
		} catch (Exception e) {
			return new ArrayList<GpsTrackInfo>();
		}
		return result;
	}

	try {
			Date startDate = TimeUtils.parseToSecond(startTime);
			Date endDate = TimeUtils.parseToSecond(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sql = "select * from bz_transport_task where bz_transport_task.TRUCK_ID = " + truckId ;
		if (startTime!=null&&endTime!=null) {
			sql+=" and  (bz_transport_task.START_TIME>=" + startTime + " or  bz_transport_task.START_TIME is null ) and (bz_transport_task.START_TIME<" + endTime + " or ? is null  )";
		}
		if(truckId!=null){
			sql+=" and   ( bz_transport_task.TEAM_ID =" + companyId + " or bz_transport_task.TRUCK_ID='') ";
		}
		NativeQuery sqlQuery = getSession().createNativeQuery(sql);
		sqlQuery.addScalar("TASK_SERIES_NUM", StandardBasicTypes.STRING);
		sqlQuery.addScalar("TEAM_ID", StandardBasicTypes.INTEGER);
		sqlQuery.addScalar("TRUCK_ID", StandardBasicTypes.INTEGER);
		sqlQuery.addScalar("START_TIME", StandardBasicTypes.DATE);
		sqlQuery.addScalar("END_TIME", StandardBasicTypes.DATE);
		sqlQuery.addScalar("CLOSED", StandardBasicTypes.INTEGER);
		sqlQuery.addScalar("SIGN_CODE", StandardBasicTypes.STRING);
		sqlQuery.addScalar("CONSOLE_CODE", StandardBasicTypes.STRING);
		sqlQuery.addScalar("COMPANY_ID", StandardBasicTypes.INTEGER);

public String queryLoss(Integer companyId,String startTime,String endTime,Integer truckId){
public String queryLossMonth(Integer companyId,Integer year,Integer truckId){
public String queryLossRank(Integer companyId,String monthAndYear){
	public String queryLevelChange(Integer teamId,String  startTime,String  endTime,Integer truckId){