SELECT DISTINCT
	concat(
		`m`.`COMPANY_ID`,
		'-',
		`m`.`TRUCK_ID`
	) AS `COMPANY_NAME`,
	`m`.`COMPANY_ID` AS `COMPANY_ID`,
	`m`.`OIL_NAME` AS `OIL_NAME`,
	LEFT (`m`.`MONTH`, 4) AS `v_year`,
	`m`.`SIGN_CODE` AS `SIGN_CODE`,
	`m`.`OIL_CODE` AS `OIL_CODE`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '01')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m1`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '02')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m2`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '03')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m3`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '04')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m4`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '05')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m5`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '06')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m6`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '07')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m7`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '08')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m8`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '09')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m9`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '10')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m10`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '11')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m11`,
	(
		SELECT
			concat(
				`m`.`V20_LOSS`,
				',',
				`m`.`V20_LOSS_RATE`,
				'%'
			) AS `LOSS`
		FROM
			`bz_transport_task_truck_mon` `vm`
		WHERE
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				AND (RIGHT(`vm`.`MONTH`, 2) = '12')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`TRUCK_ID` = `m`.`TRUCK_ID`
				)
			)
	) AS `m12`
FROM
	`bz_transport_task_truck_mon` `m`
WHERE
	isnull(`m`.`OIL_TYPE`)
UNION
	SELECT DISTINCT
		concat(
			`bttcm`.`COMPANY_NAME`,
			'-',
			`bttcm`.`OIL_CODE`
		) AS `COMPANY_NAME`,
		`bttcm`.`COMPANY_ID` AS `COMPANY_ID`,
		`bttcm`.`OIL_NAME` AS `OIL_NAME`,
		LEFT (`bttcm`.`MONTH`, 4) AS `v_year`,
		'' AS `SIGN_CODE`,
		`bttcm`.`OIL_CODE` AS `OIL_CODE`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '01'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m1`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '02'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m2`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '03'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m3`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '04'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m4`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '05'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m5`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '06'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m6`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '07'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m7`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '08'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m8`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '09'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m9`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '10'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m10`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '11'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m11`,
		(
			SELECT
				concat(
					`bttcm`.`V20_LOSS`,
					',',
					`bttcm`.`V20_LOSS_RATE`,
					'%'
				) AS `LOSS`
			FROM
				`bz_transport_task_company_mon` `vmm`
			WHERE
				(
					(
						LEFT (`vmm`.`MONTH`, 4) = LEFT (`bttcm`.`MONTH`, 4)
					)
					AND (
						RIGHT (`vmm`.`MONTH`, 2) = '12'
					)
					AND (
						`vmm`.`OIL_NAME` = `bttcm`.`OIL_NAME`
					)
					AND (
						`vmm`.`team_id` = `bttcm`.`team_id`
					)
				)
		) AS `m12`
	FROM
		`bz_transport_task_company_mon` `bttcm`
	WHERE
		isnull(`bttcm`.`OIL_TYPE`)