SELECT DISTINCT
	`m`.`OIL_NAME` AS `OIL_NAME`,
	`m`.`COMPANY_NAME` AS `COMPANY_NAME`,
	`m`.`SIGN_CODE` AS `SIGN_CODE`,
	`m`.`v_year` AS `v_year`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '01')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m1`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '02')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m2`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '03')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m3`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '04')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m4`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '05')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m5`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '06')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m6`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '07')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m7`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '08')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m8`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '09')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m9`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '10')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m10`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '11')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m11`,
	(
		SELECT
			`vm`.`LOss`
		FROM
			`v_monthloss` `vm`
		WHERE
			(
				(
					`vm`.`v_year` = `vm`.`v_year`
				)
				AND (`vm`.`v_month` = '12')
				AND (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				AND (
					`vm`.`COMPANY_NAME` = `m`.`COMPANY_NAME`
				)
				AND (
					`vm`.`SIGN_CODE` = `m`.`SIGN_CODE`
				)
			)
	) AS `m12`
FROM
	`v_monthloss` `m`