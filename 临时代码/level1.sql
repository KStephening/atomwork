SELECT
	`bsf`.`beStorageName` AS `beStorageName`,
	`bsf`.`beVT` AS `beVT`,
	`bsf`.`beV20` AS `beV20`,
	`bsf`.`beLever` AS `beLever`,
	`bsf`.`beTemp` AS `beTemp`,
	`bsf`.`beWaterH` AS `beWaterH`,
	`bsf`.`type` AS `type`,
	`bsf`.`beTaskNum` AS `beTaskNum`,
	`bsf`.`beSequence` AS `beSequence`,
	`bsf`.`beTime` AS `beTime`,
	`stationinv`.`ID` AS `stationId`,
	`stationinv`.`TIME` AS `stationinvTime`,
	`stationinv`.`WATER_HEIGHT` AS `stationinvWaterHeight`,
	`stationinv`.`VT` AS `stationinvVt`,
	`stationinv`.`V20` AS `stationinvV20`,
	`stationinv`.`TEMPERATURE` AS `stationinvTemperature`,
	`stationinv`.`TASK_SERIES_NUM` AS `stationinvTaskSeriesNum`,
	`stationinv`.`TANK_SEQUENCE` AS `stationinvTankSequence`,
	`stationinv`.`STATION_NAME` AS `stationName`,
	`stationinv`.`CORRECT_LEVEL` AS `stationinvCorrectLevel`,
	`stationinv`.`AXIAL` AS `stationinvAxial`,
	`stationinv`.`LANDSCAPE_ORIENTATION` AS `stationinvLandscapeOrientation`,
	`storageinv`.`ID` AS `storageinvId`,
	`storageinv`.`TIME` AS `storageinvTime`,
	`storageinv`.`WATER_HEIGHT` AS `storageinvWaterHeight`,
	`storageinv`.`VT` AS `storageinvVt`,
	`storageinv`.`V20` AS `storageinvV20`,
	`storageinv`.`TEMPERATURE` AS `storageinvTemperature`,
	`storageinv`.`TASK_SERIES_NUM` AS `storageinvTaskSeriesNum`,
	`storageinv`.`TANK_SEQUENCE` AS `storageinvTankSequence`,
	`storageinv`.`STORAGE_NAME` AS `storageName`,
	`storageinv`.`CORRECT_LEVEL` AS `storageinvCorrectLevel`,
	`storageinv`.`AXIAL` AS `storageinvAxial`,
	`storageinv`.`LANDSCAPE_ORIENTATION` AS `storageinvinvLandscapeOrientation`,
	`task`.`TASK_SERIES_NUM` AS `TASK_SERIES_NUM`,
	`task`.`TEAM_ID` AS `TEAM_ID`,
	`task`.`TRUCK_ID` AS `TRUCK_ID`,
	`task`.`START_TIME` AS `START_TIME`,
	`task`.`END_TIME` AS `END_TIME`,
	`task`.`CLOSED` AS `CLOSED`,
	`task`.`SIGN_CODE` AS `SIGN_CODE`,
	`task`.`CONSOLE_CODE` AS `CONSOLE_CODE`,
	`task`.`COMPANY_ID` AS `COMPANY_ID`
FROM
	(
		(
			`bz_stationtruck_tank_inventory` `stationinv` 
			JOIN `bz_storgetruck_tank_inventory` `storageinv` ON ( 
				(
					(
						`stationinv`.`TASK_SERIES_NUM` = `storageinv`.`TASK_SERIES_NUM`  
					)
					AND (
						`storageinv`.`EVENT_TYPE` IN ('MP', 'LP')   
					)
					AND (
					`stationinv`.`TANK_SEQUENCE` = `storageinv`.`TANK_SEQUENCE`  
				  )
				)
			)
		)
		JOIN `bz_transport_task` `task` ON (
			(
				(
					`storageinv`.`TASK_SERIES_NUM` = `task`.`TASK_SERIES_NUM`   
				)
				
			)
		)
	) as `vl`
	( 
		LEFT JOIN `bz_storgetruck_tank_inventory` `bsf` ON (   
			(
				(
					`bsf`.`beStorageName` = `vl`.`storageName`   
				)
				AND (
					`bsf`.`beTaskNum` = `vl`.`storageinvTaskSeriesNum`    
				)
				AND (
					`bsf`.`beSequence` = `vl`.`storageinvTankSequence`  
				)
				AND (
					`bsf`.`EVENT_TYPE` = 'LG'
				)
			)
		)
	) ;
