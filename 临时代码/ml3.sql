SELECT
	`btttm`.`COMPANY_ID` AS `COMPANY_ID`,
	`btttm`.`OIL_NAME` AS `OIL_NAME`,
	LEFT (`btttm`.`MONTH`, 4) AS `v_year`,
	RIGHT (`btttm`.`MONTH`, 2) AS `v_month`,
	`btttm`.`SIGN_CODE` AS `SIGN_CODE`,
	concat(
		`btttm`.`V20_LOSS`,
		',',
		`btttm`.`V20_LOSS_RATE`,
		'%'
	) AS `LOSS`,
	concat(
		`btttm`.`COMPANY_ID`,
		'-',
		`btttm`.`TRUCK_ID`
	) AS `COMPANY_NAME`,
	`btttm`.`OIL_CODE` AS `OIL_CODE`
FROM
	`bz_transport_task_truck_mon` `btttm`
WHERE
	isnull(`btttm`.`OIL_TYPE`)
UNION
	SELECT
		`bttcm`.`COMPANY_ID` AS `COMPANY_ID`,
		`bttcm`.`OIL_NAME` AS `OIL_NAME`,
		LEFT (`bttcm`.`MONTH`, 4) AS `v_year`,
		RIGHT (`bttcm`.`MONTH`, 2) AS `v_month`,
		'' AS `SIGN_CODE`,
		concat(
			`bttcm`.`V20_LOSS`,
			',',
			`bttcm`.`V20_LOSS_RATE`,
			'%'
		) AS `LOSS`,
		concat(
			`bttcm`.`COMPANY_NAME`,
			'-',
			`bttcm`.`OIL_CODE`
		) AS `COMPANY_NAME`,
		`bttcm`.`OIL_CODE` AS `OIL_CODE`
	FROM
		`bz_transport_task_company_mon` `bttcm`
	WHERE
		isnull(`bttcm`.`OIL_TYPE`)
	ORDER BY
		`OIL_CODE`