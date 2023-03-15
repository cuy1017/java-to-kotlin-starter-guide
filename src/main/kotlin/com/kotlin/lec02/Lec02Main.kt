package com.kotlin.lec02

/**
 * Lec02Main 2023-02-22
 *
 * Copyright Naver Webtoon Corp. All rights Reserved.
 * Naver Webtoon Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * @author yunyeon.choi@webtoonscorp.com
 * @since 2023-02-22
 * @description
 */
fun main() {
	println(startsWithA1("ABC"))
	println(startsWithA1("XYZ"))
	println(startsWithA1(null))
}

fun startsWithA1(str : String?): Boolean {
	if (str == null) {
		throw IllegalArgumentException("str is null.")
	}
	return str.startsWith("A")
}

fun startsWithA2(str : String?): Boolean? {
	if (str == null) {
		throw IllegalArgumentException("str is null.")
	}
	return str.startsWith("A")
}

val str: String? = "ABC"
//	str.length // 불가능
//	str?.length // 가능