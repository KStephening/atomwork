-- 更新bug   可以设置多个相同列属性，以最后一个为准
-- 但是插入不允许
 update
        bd_truck_company
    set
        NAME=23,
        name=3 ,
        NAmE='25sdrf3'
    where
        ID=27;
