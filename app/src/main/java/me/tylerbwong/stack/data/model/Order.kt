package me.tylerbwong.stack.data.model

import androidx.annotation.StringDef

const val ORDER_PARAM = "order"
const val DESC = "desc"
const val ASC = "asc"

@StringDef(DESC, ASC)
annotation class Order
