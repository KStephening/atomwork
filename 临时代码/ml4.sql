select distinct
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
		select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '01')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m1`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '02')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m2`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '03')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m3`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '04')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m4`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '05')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m5`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '06')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m6`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '07')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m7`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '08')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m8`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '09')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m9`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '10')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m10`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '11')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m11`,
	(
	    select
            concat(
                `m`.`V20_LOSS`,
                ',',
                `m`.`V20_LOSS_RATE`,
                '%'
            ) AS `LOSS`
		from
			`bz_transport_task_truck_mon` `vm`
		where
			(
				(
					LEFT (`vm`.`MONTH`, 4) = LEFT (`m`.`MONTH`, 4)
				)
				and (RIGHT (`vm`.`MONTH`, 2)= '12')
				and (
					`vm`.`OIL_NAME` = `m`.`OIL_NAME`
				)
				and (
					`vm`.`truck_id` = `m`.`truck_id`
				)
			)
	) AS `m12`
from
	`bz_transport_task_truck_mon` `m`
